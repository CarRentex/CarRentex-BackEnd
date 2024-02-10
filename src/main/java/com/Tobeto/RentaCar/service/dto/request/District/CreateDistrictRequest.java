package com.Tobeto.RentaCar.service.dto.request.District;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDistrictRequest {
    private String name;
    private int cityId;
}
