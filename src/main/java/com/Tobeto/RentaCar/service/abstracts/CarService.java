package com.Tobeto.RentaCar.service.abstracts;

import com.Tobeto.RentaCar.entities.Car;
import com.Tobeto.RentaCar.service.dto.request.Car.AddCarRequest;
import com.Tobeto.RentaCar.service.dto.request.Car.UpdateCarRequest;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarListResponse;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarResponse;

import java.util.List;

public interface CarService {
    List<GetCarListResponse> getAll();
    GetCarResponse getById(int id);
    void add(AddCarRequest addCarRequest);
    void update(UpdateCarRequest carRequest);
    void delete(int id);
}
