package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.concretes.Rental;
import com.Tobeto.RentaCar.repositories.RentalRepository;
import com.Tobeto.RentaCar.rules.rental.RentalBusinessRuleManager;
import com.Tobeto.RentaCar.service.abstracts.CarService;
import com.Tobeto.RentaCar.service.abstracts.RentalService;
import com.Tobeto.RentaCar.service.dto.request.Rental.AddRentalRequest;
import com.Tobeto.RentaCar.service.dto.request.Rental.UpdateRentalRequest;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarResponse;
import com.Tobeto.RentaCar.service.dto.response.Rental.GetRentalListResponse;
import com.Tobeto.RentaCar.service.dto.response.Rental.GetRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private final RentalRepository rentalRepository;
    private ModelMapperService mapperService;
    private final CarService carService;
    private final RentalBusinessRuleManager rentalBusinessRuleManager;


    @Override
    public List<GetRentalListResponse> getAll() {
        List<Rental> rentals =  rentalRepository.findAll();
        List<GetRentalListResponse> getRentalListResponses = rentals.stream()
                .map(rental->this.mapperService.forResponse()
                        .map(rental, GetRentalListResponse.class)).collect(Collectors.toList());
        return getRentalListResponses;
    }

    @Override
    public GetRentalResponse getById(int id) {
        Rental rental = rentalRepository.findById(id).orElseThrow();
        GetRentalResponse response = mapperService.forResponse().map(rental, GetRentalResponse.class);
        return response;
    }

    @Override

    public void create (AddRentalRequest rentalRequest) {
        // business rule
        rentalBusinessRuleManager.checkStartDateThanToday(rentalRequest.getStartDate().isBefore(LocalDate.now()));
        rentalBusinessRuleManager.checkEndDateThanStartDate(rentalRequest.getEndDate().isBefore(rentalRequest.getStartDate()));
        rentalBusinessRuleManager.checkMaxRentDay(rentalRequest.getStartDate().plusDays(25).isBefore(rentalRequest.getEndDate()));
        // dikkat düzeltilecek
        rentalRequest.setEndKilometer(0);

        GetCarResponse carResponse = carService.getById(rentalRequest.getCarID());
        rentalRequest.setStartKilometer(carResponse.getKilometer());
        Rental rental = mapperService.forRequest().map(rentalRequest, Rental.class);
        // dikkat düzeltilecek discount hesaplaması yeni sistemde invoice üzerinden yapılacak
//        rental.setTotalPrice(rentalRequest.getStartDate().until(rentalRequest.getEndDate(), ChronoUnit.DAYS)
//                * carResponse.getDailyPrice() * (1.0 - rentalRequest.getDiscount() / 100));
        rentalRepository.save(rental);

    }
    @Override
    public void update(UpdateRentalRequest rentalRequest) {
        rentalBusinessRuleManager.checkStartDateThanToday(rentalRequest.getStartDate().isBefore(LocalDate.now()));
        rentalBusinessRuleManager.checkEndDateThanStartDate(rentalRequest.getEndDate().isBefore(rentalRequest.getStartDate()));
        rentalBusinessRuleManager.checkMaxRentDay(rentalRequest.getStartDate().plusDays(25).isBefore(rentalRequest.getEndDate()));
        Rental rental = mapperService.forRequest().map(rentalRequest, Rental.class);
        rentalRepository.save(rental);
    }
    @Override
    public void delete(int id) {
        rentalRepository.deleteById(id);
    }
}
