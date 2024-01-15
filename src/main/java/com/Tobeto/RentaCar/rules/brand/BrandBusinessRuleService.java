package com.Tobeto.RentaCar.rules.brand;


import com.Tobeto.RentaCar.service.dto.request.Brand.AddBrandRequest;
import com.Tobeto.RentaCar.service.dto.request.Brand.UpdateBrandRequest;

public interface BrandBusinessRuleService{
    void checkIfBrandNameExists(AddBrandRequest addBrandRequest);
    void checkIfBrandNameExists(UpdateBrandRequest updateBrandRequest);

}
