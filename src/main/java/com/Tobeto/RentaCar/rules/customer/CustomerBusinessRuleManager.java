package com.Tobeto.RentaCar.rules.customer;

import com.Tobeto.RentaCar.repositories.CustomerRepository;
import com.Tobeto.RentaCar.service.dto.request.Customer.AddCustomerRequest;
import com.Tobeto.RentaCar.service.dto.request.Customer.UpdateCustomerRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerBusinessRuleManager implements CustomerBusinessRuleService{
    private final CustomerRepository customerRepository;

    @Override
    public void checkIfCustomerNameExists(String firstName, String lastName) {
        if (customerRepository.existsByFirstName(firstName))
            throw new RuntimeException("Customer available in the system");
        if (customerRepository.existsByLastName(lastName))
            throw new RuntimeException("Customer available in the system");
    }

}
