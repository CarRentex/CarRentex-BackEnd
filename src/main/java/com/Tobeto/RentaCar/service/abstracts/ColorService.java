package com.Tobeto.RentaCar.service.abstracts;

import com.Tobeto.RentaCar.service.dto.request.Car.AddCarRequest;
import com.Tobeto.RentaCar.service.dto.request.Car.UpdateCarRequest;
import com.Tobeto.RentaCar.service.dto.request.Color.AddColorRequest;
import com.Tobeto.RentaCar.service.dto.request.Color.UpdateColorRequest;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarListResponse;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarResponse;
import com.Tobeto.RentaCar.service.dto.response.Color.GetColorListResponse;
import com.Tobeto.RentaCar.service.dto.response.Color.GetColorResponse;

import java.util.List;

public interface ColorService {
    List<GetColorListResponse> getAll();
    GetColorResponse getById(int id);
    void add(AddColorRequest addColorRequest);
    void update(UpdateColorRequest colorRequest, int id);
    void delete(int id);
}
