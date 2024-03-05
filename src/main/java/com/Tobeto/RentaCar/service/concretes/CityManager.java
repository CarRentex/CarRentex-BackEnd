package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.services.WebClientService;
import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.concretes.City;
import com.Tobeto.RentaCar.entities.concretes.Color;
import com.Tobeto.RentaCar.repositories.CityRepository;
import com.Tobeto.RentaCar.service.abstracts.CityService;
import com.Tobeto.RentaCar.service.dto.request.City.CreateCityRequest;
import com.Tobeto.RentaCar.service.dto.response.City.GetAllCityAndDistirctResponse;
import com.Tobeto.RentaCar.service.dto.response.City.GetAllCityResponse;
import com.Tobeto.RentaCar.service.dto.response.City.GetCityResponse;
import com.Tobeto.RentaCar.service.dto.response.City.GetListCityResponse;
import com.Tobeto.RentaCar.service.dto.response.Color.GetColorListResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityManager implements CityService {
    private final CityRepository cityRepository;
    private final WebClientService webClientService;
    private final ModelMapperService mapperService;



    @Override
    public GetCityResponse getById(int id) {
        City city = cityRepository.getById(id);
        GetCityResponse getCityResponse = mapperService.forResponse().map(city, GetCityResponse.class);
        return getCityResponse;
    }

    @Override
    public List<GetAllCityAndDistirctResponse> getAll() {
        List<City> citys =  cityRepository.findAll();
        List<GetAllCityAndDistirctResponse> getListCityResponses = citys.stream()
                .map(color->this.mapperService.forResponse()
                        .map(color, GetAllCityAndDistirctResponse.class)).collect(Collectors.toList());
        return getListCityResponses;
    }

    @Override
    public List<GetAllCityResponse> getAllCity() {
        List<City> citys =  cityRepository.findAll();
        List<GetAllCityResponse> getAllCityResponses = citys.stream()
                .map(color->this.mapperService.forResponse()
                        .map(color, GetAllCityResponse.class)).collect(Collectors.toList());
        return getAllCityResponses;
    }

    @Override
    public void delete(int id) {
        cityRepository.deleteById(id);
    }
}
