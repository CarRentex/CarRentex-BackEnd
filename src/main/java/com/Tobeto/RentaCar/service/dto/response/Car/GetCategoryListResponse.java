package com.Tobeto.RentaCar.service.dto.response.Car;

import com.Tobeto.RentaCar.entities.concretes.Category;
import com.Tobeto.RentaCar.entities.concretes.FuelType;
import com.Tobeto.RentaCar.entities.concretes.GearType;
import com.Tobeto.RentaCar.service.dto.response.Color.GetColorResponse;
import com.Tobeto.RentaCar.service.dto.response.Model.GetModelListResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetCategoryListResponse {
        private int id;
        private int kilometer;
        private int year;
        private double dailyPrice;
        private short minFindeksRate;
        private String plate;
        private GearType gearType;
        private FuelType fuelType;
        private Category category;
        private short passengerCapacity;
        private String imagePath;
        private GetModelListResponse model;
        private GetColorResponse color;
}
