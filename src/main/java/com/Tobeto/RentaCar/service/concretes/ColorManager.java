package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.Car;
import com.Tobeto.RentaCar.entities.Color;
import com.Tobeto.RentaCar.repositories.ColorRepository;
import com.Tobeto.RentaCar.service.abstracts.ColorService;
import com.Tobeto.RentaCar.service.dto.request.Color.AddColorRequest;
import com.Tobeto.RentaCar.service.dto.request.Color.UpdateColorRequest;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarListResponse;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarResponse;
import com.Tobeto.RentaCar.service.dto.response.Color.GetColorListResponse;
import com.Tobeto.RentaCar.service.dto.response.Color.GetColorResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class ColorManager implements ColorService {
    private final ColorRepository colorRepository;
    private final ModelMapperService mapperService;

    @Override
    public List<GetColorListResponse> getAll() {
        List<Color> colors =  colorRepository.findAll();
        List<GetColorListResponse> getColorListResponses = colors.stream()
                .map(color->this.mapperService.forResponse()
                        .map(colors, GetColorListResponse.class)).collect(Collectors.toList());
        return getColorListResponses;
    }

    @Override
    public GetColorResponse getById(int id) {
        Color colors = colorRepository.findById(id).orElseThrow();
        GetColorResponse response = mapperService.forResponse().map(colors, GetColorResponse.class);
        return response;
    }

    @Override
    public void add(AddColorRequest addColorRequest) {
        if (!colorRepository.existsByName(addColorRequest.getName()))
            throw new RuntimeException("Color available in the system");
        Color colors = mapperService.forRequest().map(addColorRequest, Color.class);
        colorRepository.save(colors);
    }

    @Override
    public void update(UpdateColorRequest colorRequest, int id) {
        Color colors = mapperService.forRequest().map(colorRequest, Color.class);
        colorRepository.save(colors);
    }

    @Override
    public void delete(int id) {
        colorRepository.deleteById(id);
    }
}
