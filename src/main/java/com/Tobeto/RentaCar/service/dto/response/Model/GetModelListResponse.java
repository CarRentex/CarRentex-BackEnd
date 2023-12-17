package com.Tobeto.RentaCar.service.dto.response.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetModelListResponse {
    private String name;
    private String brandName;

}
