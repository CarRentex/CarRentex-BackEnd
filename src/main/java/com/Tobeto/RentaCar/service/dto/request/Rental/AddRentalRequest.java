package com.Tobeto.RentaCar.service.dto.request.Rental;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddRentalRequest {
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
