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
    public void checkStartDateThanToday(AddRentalRequest rentalRequest) {
        if (rentalRequest.getStartDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("The start date cannot be a date earlier than today.");
        }
    }
    @Override
    public void checkStartDateThanToday(UpdateRentalRequest rentalRequest) {
        if (rentalRequest.getStartDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("The start date cannot be a date earlier than today.");
        }
    }

    @Override
    public void checkEndDateThanStartDate(AddRentalRequest rentalRequest) {
        if (rentalRequest.getEndDate().isBefore(rentalRequest.getStartDate())) {
            throw new RuntimeException("The end date cannot be a date earlier than the start date.");
        }
    }

    @Override
    public void checkEndDateThanStartDate(UpdateRentalRequest rentalRequest) {
        if (rentalRequest.getEndDate().isBefore(rentalRequest.getStartDate())) {
            throw new RuntimeException("The end date cannot be a date earlier than the start date.");
        }
    }

    @Override
    public void checkMaxRentDay(AddRentalRequest rentalRequest) {
        if (rentalRequest.getStartDate().plusDays(25).isBefore(rentalRequest.getEndDate())) {
            throw new RuntimeException("The car can be rented for a maximum of 25 days.");
        }
    }
    @Override
    public void checkMaxRentDay(UpdateRentalRequest rentalRequest) {
        if (rentalRequest.getStartDate().plusDays(25).isBefore(rentalRequest.getEndDate())) {
            throw new RuntimeException("The car can be rented for a maximum of 25 days.");
        }
    }
}
