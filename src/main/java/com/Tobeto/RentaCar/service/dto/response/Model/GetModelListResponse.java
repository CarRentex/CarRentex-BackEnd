package com.Tobeto.RentaCar.service.dto.response.Model;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandListResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetModelListResponse {
    private int id;
    private String name;
    private GetBrandListResponse brand;

}
