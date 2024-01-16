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
    public void checkIfModelNameExists(AddModelRequest addModelRequest) {
        if (modelRepository.existsByName(addModelRequest.getName())) {
            throw new IllegalArgumentException("Model name already exists");
        }
    }

    @Override
    public void checkIfModelNameExists(UpdateModelRequest updateModelRequest) {
        if (modelRepository.existsByName(updateModelRequest.getName())) {
            throw new IllegalArgumentException("Model name already exists");
        }
    }
}
