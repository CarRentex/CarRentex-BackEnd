package com.Tobeto.RentaCar.rules.model;


import com.Tobeto.RentaCar.repositories.ModelRepository;
import com.Tobeto.RentaCar.service.dto.request.Model.AddModelRequest;
import com.Tobeto.RentaCar.service.dto.request.Model.UpdateModelRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelBusinessRuleManager implements ModelBusinessRuleService{
    private final ModelRepository modelRepository;

    @Override
    public void checkIfModelNameExists(String name) {
        if (modelRepository.existsByName(name)) {
            throw new IllegalArgumentException("Model name already exists");
        }
    }
}
