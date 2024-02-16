package com.Tobeto.RentaCar.service.dto.request.Rental;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRentalRequest {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private int startLocationId;
    private int endLocationId;
    private int carID;
    private int userID;
}
