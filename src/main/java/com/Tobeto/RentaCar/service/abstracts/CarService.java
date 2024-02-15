package com.Tobeto.RentaCar.service.abstracts;

import com.Tobeto.RentaCar.entities.concretes.Car;
import com.Tobeto.RentaCar.entities.concretes.Category;
import com.Tobeto.RentaCar.service.dto.request.Car.AddCarRequest;
import com.Tobeto.RentaCar.service.dto.request.Car.UpdateCarRequest;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarListResponse;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarResponse;
import jakarta.persistence.Tuple;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface CarService {
    List<GetCarListResponse> getAll();

    //List<GetCarListResponse> search(String name);

    GetCarResponse getById(int id);
    void create (AddCarRequest addCarRequest) throws IOException;
    void update(UpdateCarRequest carRequest);
    void delete(int id);

    List<GetCarListResponse> getAvailableCars(LocalDate startDate, LocalDate endDate);

    List<GetCarListResponse> getCategorizeCars(Category category);

    List<GetCarListResponse> filterCars(Double minPrice, Double maxPrice, Integer brandId ,Integer model);
}
