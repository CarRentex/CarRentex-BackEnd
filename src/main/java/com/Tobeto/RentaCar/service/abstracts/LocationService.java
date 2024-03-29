package com.Tobeto.RentaCar.service.abstracts;

import com.Tobeto.RentaCar.service.dto.request.Location.CreateLocationRequest;
import com.Tobeto.RentaCar.service.dto.request.Location.UpdateLocationRequest;
import com.Tobeto.RentaCar.service.dto.response.Location.GetListLocationResponse;

import java.util.List;

public interface LocationService {

    void create(CreateLocationRequest createLocation);

    List<GetListLocationResponse> getAll();

    GetListLocationResponse getById(int id);

    void update(UpdateLocationRequest updateLocationRequest);

    void delete(int id);
}