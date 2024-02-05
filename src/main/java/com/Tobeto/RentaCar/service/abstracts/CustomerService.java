package com.Tobeto.RentaCar.service.abstracts;

import com.Tobeto.RentaCar.service.dto.request.Color.AddColorRequest;
import com.Tobeto.RentaCar.service.dto.request.Color.UpdateColorRequest;
import com.Tobeto.RentaCar.service.dto.request.Customer.AddCustomerRequest;
import com.Tobeto.RentaCar.service.dto.request.Customer.UpdateCustomerRequest;
import com.Tobeto.RentaCar.service.dto.request.User.CreateUserRequest;
import com.Tobeto.RentaCar.service.dto.response.Color.GetColorListResponse;
import com.Tobeto.RentaCar.service.dto.response.Color.GetColorResponse;
import com.Tobeto.RentaCar.service.dto.response.Customer.GetCustomerListResponse;
import com.Tobeto.RentaCar.service.dto.response.Customer.GetCustomerResponse;

import java.util.List;

public interface CustomerService {
    List<GetCustomerListResponse> getAll();
    GetCustomerResponse getById(int id);
    void create (AddCustomerRequest customerRequest);
    void update(UpdateCustomerRequest customerRequest);
    void delete(int id);
}
