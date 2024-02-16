package com.Tobeto.RentaCar.rules.rental;

import com.Tobeto.RentaCar.service.dto.request.Rental.AddRentalRequest;
import com.Tobeto.RentaCar.service.dto.request.Rental.UpdateRentalRequest;

import java.time.LocalDate;

public interface RentalBusinessRuleService {
    void checkStartDateThanToday(boolean bool);
    void checkEndDateThanStartDate(boolean bool);

    void checkMaxRentDay(boolean bool);

    double totalPrice(LocalDate start, LocalDate end, double dailyPrice);

}

