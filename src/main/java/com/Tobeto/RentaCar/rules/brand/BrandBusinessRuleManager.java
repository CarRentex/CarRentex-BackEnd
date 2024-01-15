package com.Tobeto.RentaCar.rules.brand;

import com.Tobeto.RentaCar.repositories.BrandRepository;
import com.Tobeto.RentaCar.service.dto.request.Brand.AddBrandRequest;
import com.Tobeto.RentaCar.service.dto.request.Brand.UpdateBrandRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRuleManager implements BrandBusinessRuleService{
    private final BrandRepository brandRepository;
    @Override
    public void checkIfBrandNameExists(AddBrandRequest addBrandRequest) {
        if (brandRepository.existsByName(addBrandRequest.getName().trim()))
            throw new RuntimeException("brand is available in the system");
    }

    @Override
    public void checkIfBrandNameExists(UpdateBrandRequest updateBrandRequest) {
        if (brandRepository.existsByName(updateBrandRequest.getName().trim()))
            throw new RuntimeException("brand is available in the system");
    }
}
