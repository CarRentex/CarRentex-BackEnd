package com.Tobeto.RentaCar.service.dto.response.Model;


import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetModelResponse {
    private int id;
    private String name;
    private GetBrandResponse brandId;

}
