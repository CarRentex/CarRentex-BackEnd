package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
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
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private ModelMapperService mapperService;

    @Override
    public List<GetCarListResponse> getAll() {
        List<Car> cars =  carRepository.findAll();
        List<GetCarListResponse> getCarListResponses = cars.stream()
                .map(car->this.mapperService.forResponse()
                        .map(car, GetCarListResponse.class)).collect(Collectors.toList());
        return getCarListResponses;
    }

    @Override
    public GetCarResponse getById(int id) {

        Car cars = carRepository.findById(id).orElseThrow();
        GetCarResponse response = mapperService.forResponse().map(cars, GetCarResponse.class);
        return response;
    }

    @Override
    public void add(AddCarRequest addCarRequest) { // Automapping Yapıldı
        addCarRequest.setPlate(addCarRequest.getPlate().replaceAll("\\s", ""));
        if (carRepository.existsByPlate(addCarRequest.getPlate()))
                throw new RuntimeException("Plate registered in the system");
        Car car = mapperService.forRequest().map(addCarRequest, Car.class);
        carRepository.save(car);
/*        //Color color = new Color();
        car.setKilometer(addCarRequest.getKilometer());
        car.setYear(addCarRequest.getYear());
        car.setDailyPrice(addCarRequest.getDailyPrice());
        car.setPlate(addCarRequest.getPlate());
        // colorId ve modelId yapılacak*/
    }
    @Override
    public void update(UpdateCarRequest carRequest, int id) {
        // Id işlemi almalı Updatecarequesti güncelle id yi dahil et
        Car car = mapperService.forRequest().map(carRequest, Car.class);
        carRepository.save(car);
    }
    @Override
    public void delete(int id) {
        carRepository.deleteById(id);
    }
}
