package com.Tobeto.RentaCar.service.dto.request.Rental;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRentalRequest {

    @NotNull(message = "This field cannot be left blank")
    private int id;

    private LocalDate startDate;
    private LocalDate endDate;

    @NotNull(message = "This field cannot be left blank")
    private int startLocationId;

    @NotNull(message = "This field cannot be left blank")
    private int endLocationId;

    @NotNull(message = "This field cannot be left blank")
    private int carID;

    @NotNull(message = "This field cannot be left blank")
    private int userID;
}
