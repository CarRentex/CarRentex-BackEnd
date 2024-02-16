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
    private LocalDate startDate;
    private LocalDate endDate;
    private int startLocationId;
    private int endLocationId;
    private int carID;
    private int userID;
}
