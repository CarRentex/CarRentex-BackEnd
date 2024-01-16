package com.Tobeto.RentaCar.rules.corporateCustomer;

import com.Tobeto.RentaCar.repositories.CorporateCustomerRepository;
import com.Tobeto.RentaCar.service.dto.request.CorporateCustomer.AddCorporateRequest;
import com.Tobeto.RentaCar.service.dto.request.CorporateCustomer.UpdateCorporateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CorporateBusinessRuleManager implements CorporateBusinessRuleService{
    private final CorporateCustomerRepository corporateCustomerRepository;
    @Override
    public void checkIfCompanyNameExists(AddCorporateRequest addCorporateRequest) {
        if (corporateCustomerRepository.existsByCompanyName(addCorporateRequest.getCompanyName()))
            throw new RuntimeException("CompanyName available in the system");
    }

    @Override
    public void checkIfCompanyNameExists(UpdateCorporateRequest updateCorporateRequest) {
        if (corporateCustomerRepository.existsByCompanyName(updateCorporateRequest.getCompanyName()))
            throw new RuntimeException("CompanyName available in the system");
    }
}
