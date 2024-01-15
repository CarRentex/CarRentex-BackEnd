package com.Tobeto.RentaCar.rules.car;

import com.Tobeto.RentaCar.service.dto.request.Brand.AddBrandRequest;
import com.Tobeto.RentaCar.service.dto.request.Car.AddCarRequest;
import org.springframework.stereotype.Service;

@Service
public interface CarBusinessRuleService {

    void create(AddCarRequest addCarRequest);
}
