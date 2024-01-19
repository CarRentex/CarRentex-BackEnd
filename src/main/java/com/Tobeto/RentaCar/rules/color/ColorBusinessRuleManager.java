package com.Tobeto.RentaCar.rules.color;

import com.Tobeto.RentaCar.repositories.ColorRepository;
import com.Tobeto.RentaCar.service.dto.request.Color.AddColorRequest;
import com.Tobeto.RentaCar.service.dto.request.Color.UpdateColorRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ColorBusinessRuleManager implements ColorBusinessRuleService{
    private final ColorRepository colorRepository;
    @Override
    public void checkIfColorNameExists(String name) {
        if (colorRepository.existsByName(name))
            throw new RuntimeException("Color available in the system");
    }
}
