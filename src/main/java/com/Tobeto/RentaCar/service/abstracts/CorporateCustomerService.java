package com.Tobeto.RentaCar.service.abstracts;

import com.Tobeto.RentaCar.service.dto.request.CorporateCustomer.AddCorporateRequest;
import com.Tobeto.RentaCar.service.dto.request.CorporateCustomer.UpdateCorporateRequest;
import com.Tobeto.RentaCar.service.dto.response.CorporateCustomer.GetCorporateListResponse;
import com.Tobeto.RentaCar.service.dto.response.CorporateCustomer.GetCorporateResponse;

import java.util.List;

public interface CorporateCustomerService {
    List<GetCorporateListResponse> getAll();
    GetCorporateResponse getById(int id);
    void create (AddCorporateRequest addCorporateRequest);
    void update(UpdateCorporateRequest corporateRequest);
    void delete(int id);
}
