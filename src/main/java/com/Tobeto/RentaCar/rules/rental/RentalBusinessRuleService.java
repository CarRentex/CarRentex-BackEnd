package com.Tobeto.RentaCar.rules.rental;

import com.Tobeto.RentaCar.service.dto.request.Rental.AddRentalRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public interface RentalBusinessRuleService {
    void create (AddRentalRequest rentalRequest);
}
