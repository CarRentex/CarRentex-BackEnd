package com.Tobeto.RentaCar.service.abstracts;

import com.Tobeto.RentaCar.service.dto.request.City.CreateCityRequest;
import com.Tobeto.RentaCar.service.dto.request.User.CreateUserRequest;
import com.Tobeto.RentaCar.service.dto.response.City.GetAllCityAndDistirctResponse;
import com.Tobeto.RentaCar.service.dto.response.City.GetAllCityResponse;
import com.Tobeto.RentaCar.service.dto.response.City.GetCityResponse;
import com.Tobeto.RentaCar.service.dto.response.City.GetListCityResponse;
import com.Tobeto.RentaCar.service.dto.response.District.GetListDistrictResponse;

import java.util.List;

public interface CityService {

    //void create(CreateCityRequest createCityRequest);
    GetCityResponse getById(int id);
    List<GetAllCityAndDistirctResponse> getAll();
    List<GetAllCityResponse> getAllCity();

    void delete(int id);
}
