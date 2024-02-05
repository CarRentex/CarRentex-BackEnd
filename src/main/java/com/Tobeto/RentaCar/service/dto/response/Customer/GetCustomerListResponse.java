package com.Tobeto.RentaCar.service.dto.response.Customer;

import com.Tobeto.RentaCar.entities.concretes.Role;
import com.Tobeto.RentaCar.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerListResponse {
    private int id;
    private String name;
    private String surname;
    private String nationalityId;
    private String address;
    private String phoneNumber;
    private String email;
}
