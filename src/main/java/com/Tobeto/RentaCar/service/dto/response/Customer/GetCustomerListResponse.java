package com.Tobeto.RentaCar.service.dto.response.Customer;

import com.Tobeto.RentaCar.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerListResponse {
    private String nationalityId;

}
