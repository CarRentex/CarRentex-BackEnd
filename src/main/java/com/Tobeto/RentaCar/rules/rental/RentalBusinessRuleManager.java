package com.Tobeto.RentaCar.rules.rental;

import com.Tobeto.RentaCar.repositories.RentalRepository;
import com.Tobeto.RentaCar.service.dto.request.Rental.AddRentalRequest;
import com.Tobeto.RentaCar.service.dto.request.Rental.UpdateRentalRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class RentalBusinessRuleManager implements  RentalBusinessRuleService{
    private final RentalRepository rentalRepository;

    @Override
    public void checkStartDateThanToday(boolean bool) {
        if (bool) {
            throw new RuntimeException("The start date cannot be a date earlier than today.");
        }
    }

    @Override
    public void checkEndDateThanStartDate(boolean bool) {
        if (bool) {
            throw new RuntimeException("The end date cannot be a date earlier than the start date.");
        }
    }


    @Override
    public void checkMaxRentDay(boolean bool) {
        if (bool) {
            throw new RuntimeException("The car can be rented for a maximum of 25 days.");
        }
    }
}
