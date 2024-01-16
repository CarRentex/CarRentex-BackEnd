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
    public void checkIfColorNameExists(AddColorRequest addColorRequest) {
        if (colorRepository.existsByName(addColorRequest.getName()))
            throw new RuntimeException("Color available in the system");
    }

    @Override
    public void checkIfColorNameExists(UpdateColorRequest updateColorRequest) {
        if (colorRepository.existsByName(updateColorRequest.getName()))
            throw new RuntimeException("Color available in the system");
    }
}
