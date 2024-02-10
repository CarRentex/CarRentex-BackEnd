package com.Tobeto.RentaCar.service.abstracts;

import com.Tobeto.RentaCar.service.dto.request.District.CreateDistrictRequest;
import com.Tobeto.RentaCar.service.dto.response.District.GetDistrictResponse;
import com.Tobeto.RentaCar.service.dto.response.District.GetListDistrictResponse;

import java.util.List;

public interface DistrictService {
    void create(CreateDistrictRequest createDistrictRequest);
    List<GetDistrictResponse> getById(int id);
    List<GetListDistrictResponse> getAll();
    void delete(int id);
}
