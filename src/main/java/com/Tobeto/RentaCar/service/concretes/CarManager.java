package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.services.CloudinaryService;
import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.concretes.Car;
import com.Tobeto.RentaCar.entities.concretes.Category;
import com.Tobeto.RentaCar.repositories.CarRepository;
import com.Tobeto.RentaCar.rules.car.CarBusinessRuleManager;
import com.Tobeto.RentaCar.service.abstracts.BrandService;
import com.Tobeto.RentaCar.service.abstracts.CarService;
import com.Tobeto.RentaCar.service.dto.request.Car.AddCarRequest;
import com.Tobeto.RentaCar.service.dto.request.Car.UpdateCarRequest;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarListResponse;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarResponse;
import jakarta.persistence.Tuple;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private final ModelMapperService mapperService;
    private final CarBusinessRuleManager carBusinessRuleManager;
    private final BrandService brandService;

    @Override
    public List<GetCarListResponse> getAll() {
        List<Car> cars =  carRepository.findAll();
        List<GetCarListResponse> getCarListResponses = cars.stream()
                .map(car->this.mapperService.forResponse()
                        .map(car, GetCarListResponse.class)).collect(Collectors.toList());
        return getCarListResponses;
    }

/*    @Override
    public List<GetCarListResponse> search(String name) {
        List<Car> cars = carRepository.findByBrandIdIn(brandService.search(name));
        List<GetCarListResponse> getCarListResponses = cars.stream()
                .map(car->this.mapperService.forResponse()
                        .map(car, GetCarListResponse.class)).collect(Collectors.toList());
        return getCarListResponses;
    }*/

    @Override
    public GetCarResponse getById(int id) {

        Car cars = carRepository.findById(id).orElseThrow();
        GetCarResponse response = mapperService.forResponse().map(cars, GetCarResponse.class);
        return response;
    }

    @Override
    public void create (AddCarRequest addCarRequest) throws IOException { // Automapping Yapıldı
       // arabanın resmide eklenecek
        addCarRequest.setPlate(addCarRequest.getPlate().replaceAll("\\s", ""));
        carBusinessRuleManager.checkPlate(addCarRequest.getPlate());
        Car car = mapperService.forRequest().map(addCarRequest, Car.class);
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

    @Override
    public List<GetCarListResponse> getAvailableCars(LocalDate startDate, LocalDate endDate) {
        return carRepository.findAvailableCars(startDate, endDate);
    }

    @Override
    public List<GetCarListResponse> getCategorizeCars(Category category) {
        return carRepository.findByCategory(category);
    }

    @Override
    public List<GetCarListResponse> filterCars(Double minPrice, Double maxPrice, Integer modelId) {
        return carRepository.findCarsByFilter(minPrice, maxPrice, modelId);
    }
}
