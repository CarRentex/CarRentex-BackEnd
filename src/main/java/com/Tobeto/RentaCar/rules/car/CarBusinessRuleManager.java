package com.Tobeto.RentaCar.rules.car;

import com.Tobeto.RentaCar.repositories.CarRepository;
import com.Tobeto.RentaCar.service.dto.request.Car.AddCarRequest;
import com.Tobeto.RentaCar.service.dto.request.Car.UpdateCarRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarBusinessRuleManager implements CarBusinessRuleService {
    private final CarRepository carRepository;

    @Override
    public void checkPlate(String plate) {
        if (carRepository.existsByPlate(plate.trim()))
            throw new RuntimeException("Plate registered in the system");
    }
}


