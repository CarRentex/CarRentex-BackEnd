package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.concretes.Color;
import com.Tobeto.RentaCar.entities.concretes.CorporateCustomer;
import com.Tobeto.RentaCar.entities.concretes.Customer;
import com.Tobeto.RentaCar.entities.concretes.User;
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
        private final UserService userService;

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
    public void create(CreateUserRequest createUserRequest) {
        CorporateCustomer corporateCustomer = CorporateCustomer.builder()
                .companyName(createUserRequest.getCompanyName())
                .taxNo(createUserRequest.getTaxNo())
                .build();

        User userAuth = User.builder()
                .username(createUserRequest.getUsername())
                .email(createUserRequest.getEmail())
                .phoneNumber(createUserRequest.getPhoneNumber())
                .password(passwordEncoder.encode(createUserRequest.getPassword()))
                .role(createUserRequest.getRoles())
                .build();
        corporateCustomer.setUser(userService.add(userAuth));
        corporateCustomerRepository.save(corporateCustomer);
    }

    @Override
    public void update(UpdateCorporateRequest corporateRequest) {
        corporateBusinessRuleService.checkIfCompanyNameExists(corporateRequest.getCompanyName());
        CorporateCustomer corporateCustomer = mapperService.forRequest().map(corporateRequest, CorporateCustomer.class);
        corporateCustomerRepository.save(corporateCustomer);
    }

    @Override
    public void delete(int id) {
        corporateCustomerRepository.deleteById(id);
    }
}
