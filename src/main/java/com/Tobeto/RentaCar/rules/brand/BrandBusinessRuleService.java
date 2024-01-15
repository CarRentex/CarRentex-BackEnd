package com.Tobeto.RentaCar.rules.brand;

import com.Tobeto.RentaCar.service.dto.request.Brand.AddBrandRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@Service

public interface BrandBusinessRuleService{

    void create(AddBrandRequest addBrandRequest);
}
