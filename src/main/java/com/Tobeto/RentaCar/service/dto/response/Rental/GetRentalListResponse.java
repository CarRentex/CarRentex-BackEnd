package com.Tobeto.RentaCar.service.dto.response.Rental;
import com.Tobeto.RentaCar.entities.concretes.Location;
import com.Tobeto.RentaCar.service.dto.response.Location.GetListLocationResponse;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalListResponse {
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate returnDate;
    private int startKilometer;
    private int endKilometer;
    private double totalPrice;
    private GetListLocationResponse startLocation;
    private GetListLocationResponse endLocation;
}
