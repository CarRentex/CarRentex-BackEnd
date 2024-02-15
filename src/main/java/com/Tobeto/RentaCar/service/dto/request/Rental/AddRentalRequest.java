package com.Tobeto.RentaCar.service.dto.request.Rental;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddRentalRequest {
    //@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Invalid date format")
    private LocalDate startDate;
    //@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Invalid date format")
    private LocalDate endDate;
   // @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Invalid date format")
    //@Null
    private LocalDate returnDate;
    private int startKilometer;
    //@Null
    private int endKilometer;

    private double totalPrice;

    private int startLocationId;

    private int endLocationId;

    private int carID;
}
