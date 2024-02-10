package com.Tobeto.RentaCar.service.dto.response.City;

import com.Tobeto.RentaCar.entities.concretes.District;
import com.Tobeto.RentaCar.service.dto.response.District.GetListDistrictResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCityResponse {
    private String name;
    private List<GetListDistrictResponse> districts;

}
