package com.Tobeto.RentaCar.service.dto.request.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCarRequest {
    private int kilometer;
    private int year;
    private double dailyPrice;
    private String plate;
}
