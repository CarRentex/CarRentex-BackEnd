package com.Tobeto.RentaCar.rules.rental;

import com.Tobeto.RentaCar.service.dto.request.Rental.AddRentalRequest;
import com.Tobeto.RentaCar.service.dto.request.Rental.UpdateRentalRequest;

public interface RentalBusinessRuleService {
    void checkStartDateThanToday(boolean bool);
    void checkEndDateThanStartDate(boolean bool);

    void checkMaxRentDay(boolean bool);

}

