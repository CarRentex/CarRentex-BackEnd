package com.Tobeto.RentaCar.rules.rental;


import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperManager;
import com.Tobeto.RentaCar.entities.concretes.Rental;
import com.Tobeto.RentaCar.repositories.RentalRepository;
import com.Tobeto.RentaCar.service.concretes.BrandManager;
import com.Tobeto.RentaCar.service.dto.request.Rental.AddRentalRequest;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
public class RentalBusinessRuleManager implements RentalBusinessRuleService {
    private RentalRepository rentalRepository;
    private BrandManager carService;
    private ModelMapperManager mapperService;

    @Override
    public void create (AddRentalRequest rentalRequest) {
        // business rule
        if (rentalRequest.getStartDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("The start date cannot be a date earlier than today.");
        }
        if (rentalRequest.getEndDate().isBefore(rentalRequest.getStartDate())) {
            throw new RuntimeException("The end date cannot be a date earlier than the start date.");
        }
        if (rentalRequest.getStartDate().plusDays(25).isBefore(rentalRequest.getEndDate())) {
            throw new RuntimeException("The car can be rented for a maximum of 25 days.");
        }
        // dikkat düzeltilecek
        rentalRequest.setEndKilometer(0);

        GetCarResponse carResponse = carService.getById(rentalRequest.getCarID());
        rentalRequest.setStartKilometer(carResponse.getKilometer());
        Rental rental = mapperService.forRequest().map(rentalRequest, Rental.class);
        rental.setTotalPrice(rentalRequest.getStartDate().until(rentalRequest.getEndDate(), ChronoUnit.DAYS)
                * carResponse.getDailyPrice() * (1.0 - rentalRequest.getDiscount() / 100));
        rentalRepository.save(rental);
    }


}
