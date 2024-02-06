package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.utilites.globalCheck.GlobalCheckService;
import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.concretes.Color;
import com.Tobeto.RentaCar.entities.concretes.Customer;
import com.Tobeto.RentaCar.entities.concretes.Role;
import com.Tobeto.RentaCar.entities.concretes.User;
import com.Tobeto.RentaCar.repositories.CustomerRepository;
import com.Tobeto.RentaCar.rules.customer.CustomerBusinessRuleManager;
import com.Tobeto.RentaCar.service.abstracts.CustomerService;
import com.Tobeto.RentaCar.service.abstracts.UserService;
import com.Tobeto.RentaCar.service.dto.request.Customer.AddCustomerRequest;
import com.Tobeto.RentaCar.service.dto.request.Customer.UpdateCustomerRequest;
import com.Tobeto.RentaCar.service.dto.request.User.CreateUserRequest;
import com.Tobeto.RentaCar.service.dto.response.Color.GetColorListResponse;
import com.Tobeto.RentaCar.service.dto.response.Customer.GetCustomerListResponse;
import com.Tobeto.RentaCar.service.dto.response.Customer.GetCustomerResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final ModelMapperService mapperService;
    private final CustomerRepository customerRepository;
    private final CustomerBusinessRuleManager customerBusinessRuleManager;
    private final PasswordEncoder passwordEncoder;

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
        Customer customerEntity = mapperService.forResponse().map(addCustomerRequest, Customer.class);
        customerEntity.setPassword(passwordEncoder.encode(addCustomerRequest.getPassword()));
        customerEntity.setRole(Role.CUSTOMER);
        this.customerRepository.save(customerEntity);
    }

    @Override
    public void update(UpdateCustomerRequest customerRequest) {
        Customer extisingCustomer = customerRepository.findById(customerRequest.getId()).orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı"));
        Customer customer =mapperService.forRequest().map(
                customerRequest, Customer.class);
        customer.setPassword(extisingCustomer.getPassword());
        customer.setRole(Role.CUSTOMER);
        customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }




}
