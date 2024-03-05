package com.Tobeto.RentaCar.service.dto.response.City;

import com.Tobeto.RentaCar.service.dto.response.District.GetListDistrictResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCityAndDistirctResponse {
    private int id;
    private String name;
    private List<GetListDistrictResponse> districts;
}
