package com.Tobeto.RentaCar.rules.rental;

import com.Tobeto.RentaCar.service.dto.request.Rental.AddRentalRequest;
import com.Tobeto.RentaCar.service.dto.request.Rental.UpdateRentalRequest;

public interface RentalBusinessRuleService {
    void checkStartDateThanToday(AddRentalRequest rentalRequest);
    void checkStartDateThanToday(UpdateRentalRequest rentalRequest);
    void checkEndDateThanStartDate(AddRentalRequest rentalRequest);
    void checkEndDateThanStartDate(UpdateRentalRequest rentalRequest);

    void checkMaxRentDay(AddRentalRequest rentalRequest);
    void checkMaxRentDay(UpdateRentalRequest rentalRequest);

}

