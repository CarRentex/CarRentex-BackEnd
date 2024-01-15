package com.Tobeto.RentaCar.rules.brand;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperManager;
import com.Tobeto.RentaCar.entities.concretes.Brand;
import com.Tobeto.RentaCar.repositories.BrandRepository;
import com.Tobeto.RentaCar.service.dto.request.Brand.AddBrandRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRuleManager   implements BrandBusinessRuleService{
    private BrandRepository brandRepository;
    private ModelMapperManager mapperService;

    @Override
    public void create (AddBrandRequest addBrandRequest) {

        if (brandRepository.existsByName(addBrandRequest.getName().trim()))
            throw new RuntimeException("Brand is available in the system");

        Brand brand;
        brand = this.mapperService.forRequest().map(addBrandRequest, Brand.class);
        this.brandRepository.save(brand);


    }

}


