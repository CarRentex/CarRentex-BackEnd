package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.Car;
import com.Tobeto.RentaCar.entities.Rental;
import com.Tobeto.RentaCar.repositories.RentalRepository;
import com.Tobeto.RentaCar.service.abstracts.RentalService;
import com.Tobeto.RentaCar.service.dto.request.Rental.AddRentalRequest;
import com.Tobeto.RentaCar.service.dto.request.Rental.UpdateRentalRequest;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarListResponse;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarResponse;
import com.Tobeto.RentaCar.service.dto.response.Rental.GetRentalListResponse;
import com.Tobeto.RentaCar.service.dto.response.Rental.GetRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private final RentalRepository rentalRepository;
    private ModelMapperService mapperService;

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
    public void add(AddRentalRequest rentalRequest) {
        // business rule
        if (rentalRequest.getStartDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("Başlangıç tarihi bugünden daha geçmiş bir tarih olamaz.");
        }
        // Bitiş tarihi başlangıç tarihinden daha geçmiş bir tarih olamaz.
        if (rentalRequest.getEndDate().isBefore(rentalRequest.getStartDate())) {
            throw new RuntimeException("Bitiş tarihi başlangıç tarihinden daha geçmiş bir tarih olamaz.");
        }
      // Bir araç maksimum 25 gün kiralanabilir.
        if (rentalRequest.getStartDate().plusDays(25).isBefore(rentalRequest.getEndDate())) {
            throw new RuntimeException("Araç maksimum 25 gün kiralanabilir.");
        }
        Rental rental = mapperService.forRequest().map(rentalRequest, Rental.class);
        rentalRepository.save(rental);
    }

    @Override
    public void update(UpdateRentalRequest rentalRequest) {
        Rental rental = mapperService.forRequest().map(rentalRequest, Rental.class);
        rentalRepository.save(rental);
    }

    @Override
    public void delete(int id) {
        rentalRepository.deleteById(id);
    }
}
