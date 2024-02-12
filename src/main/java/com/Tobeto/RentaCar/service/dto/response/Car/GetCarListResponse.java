package com.Tobeto.RentaCar.service.dto.response.Car;

import com.Tobeto.RentaCar.entities.concretes.Category;
import com.Tobeto.RentaCar.entities.concretes.FuelType;
import com.Tobeto.RentaCar.entities.concretes.GearType;
import com.Tobeto.RentaCar.service.dto.response.Color.GetColorResponse;
import com.Tobeto.RentaCar.service.dto.response.Model.GetModelListResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarListResponse {
    private int id;
    private int kilometer;
    private int year;
    private double dailyPrice;
    private double deposit;
    private short minFindeksRate;
    private String plate;
    private GearType gearType;
    private FuelType fuelType;
    private Category category;
    private GetColorResponse color;
    private short passengerCapacity;
    private GetModelListResponse model;
    private String imagePath;
}
