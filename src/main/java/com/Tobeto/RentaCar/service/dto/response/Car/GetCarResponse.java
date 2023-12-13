package com.Tobeto.RentaCar.service.dto.response.Car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCarResponse {
    private int kilometer;
    private int year;
    private double dailyPrice;
    private String plate;
}
