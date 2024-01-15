package com.Tobeto.RentaCar.rules.color;

import com.Tobeto.RentaCar.service.dto.request.Color.AddColorRequest;
import org.springframework.stereotype.Service;

@Service
public interface ColorBusinessRuleService {
    void create (AddColorRequest addColorRequest);
}
