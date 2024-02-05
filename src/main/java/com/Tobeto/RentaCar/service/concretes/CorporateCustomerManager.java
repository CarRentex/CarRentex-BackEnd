package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.concretes.*;
import com.Tobeto.RentaCar.repositories.CorporateCustomerRepository;
import com.Tobeto.RentaCar.rules.corporateCustomer.CorporateBusinessRuleService;
import com.Tobeto.RentaCar.service.abstracts.CorporateCustomerService;
import com.Tobeto.RentaCar.service.abstracts.UserService;
import com.Tobeto.RentaCar.service.dto.request.CorporateCustomer.AddCorporateRequest;
import com.Tobeto.RentaCar.service.dto.request.CorporateCustomer.UpdateCorporateRequest;
import com.Tobeto.RentaCar.service.dto.request.User.CreateUserRequest;
import com.Tobeto.RentaCar.service.dto.response.Color.GetColorListResponse;
import com.Tobeto.RentaCar.service.dto.response.CorporateCustomer.GetCorporateListResponse;
import com.Tobeto.RentaCar.service.dto.response.CorporateCustomer.GetCorporateResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CorporateCustomerManager implements CorporateCustomerService {
        private final CorporateCustomerRepository corporateCustomerRepository;
        private final ModelMapperService mapperService;
        private final CorporateBusinessRuleService corporateBusinessRuleService;
        private final PasswordEncoder passwordEncoder;

    @Override
    public List<GetCorporateListResponse> getAll() {
        List<CorporateCustomer> corporateCustomers =  corporateCustomerRepository.findAll();
        List<GetCorporateListResponse> getCorporateListResponses = corporateCustomers.stream()
                .map(corporate->this.mapperService.forResponse()
                        .map(corporate, GetCorporateListResponse.class)).collect(Collectors.toList());
        return getCorporateListResponses;
    }

    @Override
    public GetCorporateResponse getById(int id) {
        CorporateCustomer corporateCustomer = corporateCustomerRepository.findById(id).orElseThrow();
        GetCorporateResponse response = mapperService.forResponse().map(corporateCustomer, GetCorporateResponse.class);
        return response;
    }

    @Override
    public void create(AddCorporateRequest createUserRequest) {
        CorporateCustomer corporateCustomer = mapperService.forRequest().map(createUserRequest, CorporateCustomer.class);
        corporateCustomer.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
        corporateCustomer.setRole(Role.CUSTOMER);
        corporateCustomerRepository.save(corporateCustomer);
    }

    @Override
    public void update(UpdateCorporateRequest corporateRequest) {

        corporateBusinessRuleService.checkIfCompanyNameExists(corporateRequest.getCompanyName());
        CorporateCustomer corporateCustom = corporateCustomerRepository.findById(corporateRequest.getId()).orElseThrow();
        CorporateCustomer corporate =mapperService.forRequest().map(
                corporateRequest, CorporateCustomer.class);
        corporate.setPassword(corporateCustom.getPassword());
        corporate.setRole(Role.CUSTOMER);
        corporateCustomerRepository.save(corporate);
    }

    @Override
    public void delete(int id) {
        corporateCustomerRepository.deleteById(id);
    }
}
