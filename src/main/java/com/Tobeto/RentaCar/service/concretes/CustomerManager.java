package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.concretes.Color;
import com.Tobeto.RentaCar.entities.concretes.Customer;
import com.Tobeto.RentaCar.repositories.CustomerRepository;
import com.Tobeto.RentaCar.rules.customer.CustomerBusinessRuleManager;
import com.Tobeto.RentaCar.service.abstracts.CustomerService;
import com.Tobeto.RentaCar.service.dto.request.Customer.AddCustomerRequest;
import com.Tobeto.RentaCar.service.dto.request.Customer.UpdateCustomerRequest;
import com.Tobeto.RentaCar.service.dto.response.Color.GetColorListResponse;
import com.Tobeto.RentaCar.service.dto.response.Customer.GetCustomerListResponse;
import com.Tobeto.RentaCar.service.dto.response.Customer.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final ModelMapperService mapperService;
    private final CustomerRepository customerRepository;
    private final CustomerBusinessRuleManager customerBusinessRuleManager;

    @Override
    public List<GetCustomerListResponse> getAll() {
        List<Customer> customer =  customerRepository.findAll();
        List<GetCustomerListResponse> getCustomerListResponses = customer.stream()
                .map(Customer->this.mapperService.forResponse()
                        .map(Customer, GetCustomerListResponse.class)).collect(Collectors.toList());
        return getCustomerListResponses;
    }

    @Override
    public GetCustomerResponse getById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        GetCustomerResponse response = mapperService.forResponse().map(customer, GetCustomerResponse.class);
        return response;
    }

    @Override
    public void create(AddCustomerRequest addCustomerRequest) {
        customerBusinessRuleManager.checkIfCustomerNameExists(addCustomerRequest);
        Customer customer = mapperService.forRequest().map(addCustomerRequest, Customer.class);
        customerRepository.save(customer);

    }

    @Override
    public void update(UpdateCustomerRequest customerRequest) {

    }

    @Override
    public void delete(int id) {

    }
    //private final CustomerBusinessRuleManager customerBusinessRuleManager;




}
