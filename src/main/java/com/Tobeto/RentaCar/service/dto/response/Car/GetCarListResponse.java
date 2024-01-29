package com.Tobeto.RentaCar.service.dto.response.Car;

import com.Tobeto.RentaCar.entities.concretes.Category;
import com.Tobeto.RentaCar.entities.concretes.FuelType;
import com.Tobeto.RentaCar.entities.concretes.TransmissionType;
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
    private TransmissionType transmissionType;
    private FuelType fuelType;
    private Category category;
    private String colorName;
    private short passengerCapacity;
    private String modelName;
    private String brandName;
    private String imagePath;
}
