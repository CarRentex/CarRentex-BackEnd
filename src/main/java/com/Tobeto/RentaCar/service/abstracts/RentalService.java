package com.Tobeto.RentaCar.service.abstracts;

import com.Tobeto.RentaCar.service.dto.request.Rental.AddRentalRequest;
import com.Tobeto.RentaCar.service.dto.request.Rental.UpdateRentalRequest;
import com.Tobeto.RentaCar.service.dto.response.Rental.GetRentalListResponse;
import com.Tobeto.RentaCar.service.dto.response.Rental.GetRentalResponse;

import java.util.List;

public interface RentalService {
    List<GetRentalListResponse> getAll();
    GetRentalResponse getById(int id);
    void create(AddRentalRequest rentalRequest);
    void update(UpdateRentalRequest rentalRequest);
    void delete(int id);

    List<Object[]> calculateYearlyIncome(int year);
}
