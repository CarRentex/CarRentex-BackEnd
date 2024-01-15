package com.Tobeto.RentaCar.rules.car;

import com.Tobeto.RentaCar.entities.concretes.Car;
import com.Tobeto.RentaCar.repositories.CarRepository;
import com.Tobeto.RentaCar.service.dto.request.Car.AddCarRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarBusinessRuleManager implements CarBusinessRuleService{
    private CarRepository carRepository;

    @Override
    public void create(AddCarRequest addCarRequest) { // Automapping Yapıldı
        addCarRequest.setPlate(addCarRequest.getPlate().replaceAll("\\s", ""));
        if (carRepository.existsByPlate(addCarRequest.getPlate()))
            throw new RuntimeException("Plate registered in the system");
        Car car;
        car = mapperService.forRequest().map(addCarRequest, Car.class);
        carRepository.save(car);
    }
}
