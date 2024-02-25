package com.Tobeto.RentaCar.service.abstracts;
import com.Tobeto.RentaCar.service.dto.request.Model.AddModelRequest;
import com.Tobeto.RentaCar.service.dto.request.Model.UpdateModelRequest;
import com.Tobeto.RentaCar.service.dto.response.Model.GetModelByBrandId;
import com.Tobeto.RentaCar.service.dto.response.Model.GetModelListResponse;
import com.Tobeto.RentaCar.service.dto.response.Model.GetModelResponse;

import java.util.List;

public interface ModelService {
    List<GetModelListResponse> getAll();
    GetModelResponse getById(int id);
    void create (AddModelRequest addModelRequest);
    void update(UpdateModelRequest modelRequest);
    void delete(int id);

    List<GetModelByBrandId> getByBrandId(int id);

}
