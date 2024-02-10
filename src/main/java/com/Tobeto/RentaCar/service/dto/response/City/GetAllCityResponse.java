package com.Tobeto.RentaCar.service.dto.response.City;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCityResponse {
    private int id;
    private String name;
}
