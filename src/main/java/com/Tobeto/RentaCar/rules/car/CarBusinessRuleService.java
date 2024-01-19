package com.Tobeto.RentaCar.rules.car;

import com.Tobeto.RentaCar.service.dto.request.Car.AddCarRequest;
import com.Tobeto.RentaCar.service.dto.request.Car.UpdateCarRequest;

public interface CarBusinessRuleService {
    void checkPlate(String plate);

}
