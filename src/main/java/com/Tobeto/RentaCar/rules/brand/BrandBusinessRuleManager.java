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
    public void checkIfBrandNameExists(String name) {
        if (brandRepository.existsByName(name.trim()))
            throw new RuntimeException("brand is available in the system");
    }

}
