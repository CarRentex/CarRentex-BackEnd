package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.entities.Car;
import com.Tobeto.RentaCar.entities.Color;
import com.Tobeto.RentaCar.repositories.CarRepository;
import com.Tobeto.RentaCar.service.abstracts.CarService;
import com.Tobeto.RentaCar.service.dto.request.Car.AddCarRequest;
import com.Tobeto.RentaCar.service.dto.request.Car.UpdateCarRequest;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarListResponse;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final CarRepository carRepository;

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public GetCarResponse getById(int id) {
        return null;
    }

    @Override
    public void add(AddCarRequest addCarRequest) {
        carRepository.existsByPlate(addCarRequest.getPlate().replaceAll("\\s", ""));
        Car car = new Car();
        //Color color = new Color();
        car.setKilometer(addCarRequest.getKilometer());
        car.setYear(addCarRequest.getYear());
        car.setDailyPrice(addCarRequest.getDailyPrice());
        car.setPlate(addCarRequest.getPlate());
        // colorId ve modelId yapılacak
        carRepository.save(car);
    }
    @Override
    public void update(UpdateCarRequest carRequest, int id) {

    }

    @Override
    public void delete(int id) {

    }
}
