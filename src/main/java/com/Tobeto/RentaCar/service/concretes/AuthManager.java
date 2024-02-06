package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.services.JwtService;
import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.rules.auth.AuthRulesService;
import com.Tobeto.RentaCar.service.abstracts.*;
import com.Tobeto.RentaCar.service.dto.request.Admin.CreateAdminRequest;
import com.Tobeto.RentaCar.service.dto.request.CorporateCustomer.AddCorporateRequest;
import com.Tobeto.RentaCar.service.dto.request.Customer.AddCustomerRequest;
import com.Tobeto.RentaCar.service.dto.request.User.CreateUserRequest;
import com.Tobeto.RentaCar.service.dto.request.User.LoginUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final CustomerService customerService;
    private final CorporateCustomerService corporateCustomerService;
    private final AuthRulesService authRulesService;
    private final ModelMapperService modelMapperService;
    private final AdminService adminService;
    @Override
    public void register(CreateUserRequest createUserRequest) {
        //authRulesService.checkIfEmailExists(createUserRequest.getEmail());

        switch (createUserRequest.getRole()){
                case ADMIN:
                    this.adminService.create(this.modelMapperService.forRequest().map(createUserRequest, CreateAdminRequest.class));
                    break;
                case CUSTOMER:
                    this.customerService.create(this.modelMapperService.forRequest().map(createUserRequest, AddCustomerRequest.class));
                    break;
                case CORPORATE_CUSTOMER:
                    this.corporateCustomerService.create(this.modelMapperService.forRequest().map(createUserRequest, AddCorporateRequest.class));
                break;
        }
    }
    @Override
    public String login(LoginUserRequest loginRequest) {
        System.out.println(loginRequest.getEmail() + " " + loginRequest.getPassword());
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        if(authentication.isAuthenticated())
        {
            return jwtService.generateToken(loginRequest.getEmail());
        }

        throw new RuntimeException("Kullanıcı adı ya da şifre yanlış");
    }
}