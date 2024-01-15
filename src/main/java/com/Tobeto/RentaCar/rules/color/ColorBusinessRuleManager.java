package com.Tobeto.RentaCar.rules.color;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperManager;
import com.Tobeto.RentaCar.entities.concretes.Color;
import com.Tobeto.RentaCar.repositories.ColorRepository;
import com.Tobeto.RentaCar.service.dto.request.Color.AddColorRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class ColorBusinessRuleManager implements ColorBusinessRuleService{
    private ColorRepository colorRepository;
    private ModelMapperManager mapperService;

    @Override
    public void create(AddColorRequest addColorRequest) {
        if (colorRepository.existsByName(addColorRequest.getName()))
            throw new RuntimeException("Color available in the system");
        Color colors = mapperService.forRequest().map(addColorRequest, Color.class);
        colorRepository.save(colors);
    }
}
