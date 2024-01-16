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
    public void checkPlate(AddCarRequest addCarRequest) {
        if (carRepository.existsByPlate(addCarRequest.getPlate()))
            throw new RuntimeException("Plate registered in the system");
    }

    @Override
    public void checkPlate(UpdateCarRequest updateCarRequest) {
        if (carRepository.existsByPlate(updateCarRequest.getPlate()))
            throw new RuntimeException("Plate registered in the system");
    }
}


