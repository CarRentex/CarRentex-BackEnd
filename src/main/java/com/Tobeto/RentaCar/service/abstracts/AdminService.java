package com.Tobeto.RentaCar.service.abstracts;

import com.Tobeto.RentaCar.service.dto.request.Admin.CreateAdminRequest;
import com.Tobeto.RentaCar.service.dto.request.Admin.UpdateAdminRequest;
import com.Tobeto.RentaCar.service.dto.request.Customer.AddCustomerRequest;
import com.Tobeto.RentaCar.service.dto.request.Customer.UpdateCustomerRequest;
import com.Tobeto.RentaCar.service.dto.response.Admin.GetAdminListResponse;
import com.Tobeto.RentaCar.service.dto.response.Admin.GetAdminResponse;
import com.Tobeto.RentaCar.service.dto.response.Customer.GetCustomerListResponse;
import com.Tobeto.RentaCar.service.dto.response.Customer.GetCustomerResponse;

import java.util.List;

public interface AdminService {
    List<GetAdminListResponse> getAll();
    GetAdminResponse getById(int id);
    void create (CreateAdminRequest AdminRequest);
    void update(UpdateAdminRequest AdminRequest);
    void delete(int id);
}
