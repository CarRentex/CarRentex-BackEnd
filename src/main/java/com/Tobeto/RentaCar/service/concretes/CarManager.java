package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.services.CloudinaryService;
import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.concretes.Car;
import com.Tobeto.RentaCar.repositories.CarRepository;
import com.Tobeto.RentaCar.rules.car.CarBusinessRuleManager;
import com.Tobeto.RentaCar.service.abstracts.CarService;
import com.Tobeto.RentaCar.service.dto.request.Car.AddCarRequest;
import com.Tobeto.RentaCar.service.dto.request.Car.UpdateCarRequest;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarListResponse;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private final ModelMapperService mapperService;
    private final CarBusinessRuleManager carBusinessRuleManager;
    private final CloudinaryService cloudinaryService;

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
    public void create (AddCarRequest addCarRequest, MultipartFile file) throws IOException { // Automapping Yapıldı
       // arabanın resmide eklenecek
        String imagePath = cloudinaryService.uploadImage(file);
        addCarRequest.setPlate(addCarRequest.getPlate().replaceAll("\\s", ""));
        carBusinessRuleManager.checkPlate(addCarRequest.getPlate());
        Car car = mapperService.forRequest().map(addCarRequest, Car.class);
        car.setImagePath(imagePath);
        carRepository.save(car);
    }
    @Override
    public void update(UpdateCarRequest carRequest) {
        carRequest.setPlate(carRequest.getPlate().replaceAll("\\s", ""));
        carBusinessRuleManager.checkPlate(carRequest.getPlate());
        Car car = mapperService.forRequest().map(carRequest, Car.class);
        carRepository.save(car);
    }
    @Override
    public void delete(int id) {
        carRepository.deleteById(id);
    }
}
