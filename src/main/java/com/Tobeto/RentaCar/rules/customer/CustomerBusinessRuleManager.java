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
    public void checkIfCustomerNameExists(AddCustomerRequest addCustomerRequest) {
        if (customerRepository.existsByFirstName(addCustomerRequest.getFirstName()))
            throw new RuntimeException("Customer available in the system");
        if (customerRepository.existsByLastName(addCustomerRequest.getLastName()))
            throw new RuntimeException("Customer available in the system");
    }

    @Override
    public void checkIfCustomerNameExists(UpdateCustomerRequest updateCustomerRequest) {
        if (customerRepository.existsByFirstName(updateCustomerRequest.getFirstName()))
            throw new RuntimeException("Customer FirstName available in the system");
        if (customerRepository.existsByLastName(updateCustomerRequest.getLastName()))
            throw new RuntimeException("Customer LastName available in the system");
    }
}
