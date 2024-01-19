package com.Tobeto.RentaCar.rules.color;

import com.Tobeto.RentaCar.service.dto.request.Color.AddColorRequest;
import com.Tobeto.RentaCar.service.dto.request.Color.UpdateColorRequest;

public interface ColorBusinessRuleService {
    void checkIfColorNameExists(String name);
}
