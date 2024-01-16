package com.Tobeto.RentaCar.rules.corporateCustomer;

import com.Tobeto.RentaCar.service.dto.request.CorporateCustomer.AddCorporateRequest;
import com.Tobeto.RentaCar.service.dto.request.CorporateCustomer.UpdateCorporateRequest;

public interface CorporateBusinessRuleService {
    void checkIfCompanyNameExists(AddCorporateRequest addCorporateRequest);

    void checkIfCompanyNameExists(UpdateCorporateRequest updateCorporateRequest);

}
