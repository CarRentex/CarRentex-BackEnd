package com.Tobeto.RentaCar.service.dto.response.Car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarListResponse {
    private int kilometer;
    private int year;
    private double dailyPrice;
    private String plate;
    //private int colorId;
    //private int modelId;
}
