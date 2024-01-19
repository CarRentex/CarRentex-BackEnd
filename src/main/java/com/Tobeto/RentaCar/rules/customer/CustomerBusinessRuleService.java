package com.Tobeto.RentaCar.rules.customer;


import com.Tobeto.RentaCar.service.dto.request.Customer.AddCustomerRequest;
import com.Tobeto.RentaCar.service.dto.request.Customer.UpdateCustomerRequest;

public interface CustomerBusinessRuleService {
    void checkIfCustomerNameExists(String firstName, String lastName);

}
