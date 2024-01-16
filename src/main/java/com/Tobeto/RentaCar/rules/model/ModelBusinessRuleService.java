package com.Tobeto.RentaCar.rules.model;

import com.Tobeto.RentaCar.service.dto.request.Model.AddModelRequest;
import com.Tobeto.RentaCar.service.dto.request.Model.UpdateModelRequest;

public interface ModelBusinessRuleService {
    void checkIfModelNameExists(AddModelRequest addModelRequest);
    void checkIfModelNameExists(UpdateModelRequest updateModelRequest);

}
