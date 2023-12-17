package com.Tobeto.RentaCar.service.dto.request.Rental;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
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
    private Integer endKilometer;
    private double totalPrice;
    private double discount;
    private int carID;
}
