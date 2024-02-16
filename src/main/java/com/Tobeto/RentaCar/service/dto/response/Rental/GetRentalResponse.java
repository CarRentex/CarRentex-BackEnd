package com.Tobeto.RentaCar.service.dto.response.Rental;

import com.Tobeto.RentaCar.service.dto.response.Car.GetCarResponse;
import com.Tobeto.RentaCar.service.dto.response.Location.GetListLocationResponse;
import com.Tobeto.RentaCar.service.dto.response.User.GetUserListResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetRentalResponse {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    //private int startKilometer;
    //private int endKilometer;
    private double totalPrice;
    private GetListLocationResponse startLocation;
    private GetListLocationResponse endLocation;
    private GetCarResponse car;
    private GetUserListResponse user;
}
