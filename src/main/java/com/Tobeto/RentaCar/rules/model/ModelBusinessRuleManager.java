package com.Tobeto.RentaCar.rules.model;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperManager;
import com.Tobeto.RentaCar.entities.concretes.Model;
import com.Tobeto.RentaCar.repositories.ModelRepository;
import com.Tobeto.RentaCar.service.dto.request.Model.AddModelRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelBusinessRuleManager implements ModelBusinessRuleService {
    private ModelRepository modelRepository;
    private ModelMapperManager mapperService;

    @Override
    public void create(AddModelRequest addModelRequest) {
        if (modelRepository.existsByName(addModelRequest.getName()))
            throw new RuntimeException("Model available in the system");

        Model model = mapperService.forRequest().map(addModelRequest, Model.class);
        modelRepository.save(model);

    }
}
