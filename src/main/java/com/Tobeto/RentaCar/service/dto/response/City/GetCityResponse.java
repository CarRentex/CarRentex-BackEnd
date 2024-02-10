package com.Tobeto.RentaCar.service.dto.response.City;

import com.Tobeto.RentaCar.service.dto.response.District.GetDistrictResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCityResponse {
    private String name;
}
