package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.concretes.Color;
import com.Tobeto.RentaCar.entities.concretes.Customer;
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
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final ModelMapperService mapperService;
    private final CustomerRepository customerRepository;
    private final CustomerBusinessRuleManager customerBusinessRuleManager;
    private final UserService userService;
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
    public void create(CreateUserRequest createUserRequest) {

        // business rules
       // customerBusinessRuleManager.checkIfCustomerNameExists(addCustomerRequest.getFirstName(),addCustomerRequest.getLastName());
        Customer customer = Customer.builder()
                .firstName(createUserRequest.getFirstName())
                .lastName(createUserRequest.getLastName())
                .nationalityId(createUserRequest.getNationalityId())
                .address(createUserRequest.getAddress())
                .build();

        User userAuth = User.builder()
                .username(createUserRequest.getUsername())
                .email(createUserRequest.getEmail())
                .phoneNumber(createUserRequest.getPhoneNumber())
                .password(passwordEncoder.encode(createUserRequest.getPassword()))
                .role(createUserRequest.getRoles())
                .build();
        customer.setUser(userService.add(userAuth));
        customerRepository.save(customer);
    }

    @Override
    public void update(UpdateCustomerRequest customerRequest) {
        //customerBusinessRuleManager.checkIfCustomerNameExists(customerRequest.getFirstName(),customerRequest.getLastName());
        Customer customer = mapperService.forRequest().map(customerRequest, Customer.class);
        customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }




}
