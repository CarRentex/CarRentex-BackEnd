package com.Tobeto.RentaCar.service.abstracts;
import com.Tobeto.RentaCar.service.dto.request.Model.AddModelRequest;
import com.Tobeto.RentaCar.service.dto.request.Model.UpdateModelRequest;
import com.Tobeto.RentaCar.service.dto.response.Model.GetModelListResponse;
import com.Tobeto.RentaCar.service.dto.response.Model.GetModelResponse;

import java.util.List;

public interface ModelService {
    List<GetModelListResponse> getAll();
    GetModelResponse getById(int id);
    void add(AddModelRequest addModelRequest);
    void update(UpdateModelRequest modelRequest);
    void delete(int id);

}
