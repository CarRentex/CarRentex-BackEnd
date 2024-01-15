package com.Tobeto.RentaCar.rules.model;

import com.Tobeto.RentaCar.service.dto.request.Model.AddModelRequest;

public interface ModelBusinessRuleService {
    void create (AddModelRequest addModelRequest);
}
