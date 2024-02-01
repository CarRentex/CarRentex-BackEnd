package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.services.JwtService;
import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.concretes.CorporateCustomer;
import com.Tobeto.RentaCar.entities.concretes.Customer;
import com.Tobeto.RentaCar.entities.concretes.Role;
import com.Tobeto.RentaCar.entities.concretes.User;
import com.Tobeto.RentaCar.service.abstracts.AuthService;
import com.Tobeto.RentaCar.service.abstracts.CorporateCustomerService;
import com.Tobeto.RentaCar.service.abstracts.CustomerService;
import com.Tobeto.RentaCar.service.abstracts.UserService;
import com.Tobeto.RentaCar.service.dto.request.Customer.AddCustomerRequest;
import com.Tobeto.RentaCar.service.dto.request.User.CreateUserRequest;
import com.Tobeto.RentaCar.service.dto.request.User.LoginUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final CustomerService customerService;
    private final CorporateCustomerService corporateCustomerService;
    @Override
    public void register(CreateUserRequest createUserRequest) {

        // mapleme işlemi yap toparla burayı

/*        User user = User.builder()
                .username(createUserRequest.getUsername())
                .email(createUserRequest.getEmail())
                .phoneNumber(createUserRequest.getPhoneNumber())
                .role(createUserRequest.getRoles())
                .password(passwordEncoder.encode(createUserRequest.getPassword()))
                .build();*/
        switch (createUserRequest.getRoles()){
            case ADMIN:
                break;
            case CUSTOMER:
                this.customerService.create(createUserRequest);
                //userService.add(user);
                break;
            case CORPORATE_CUSTOMER:
                this.corporateCustomerService.create(createUserRequest);
                break;
        }
/*        if (user.getRole().equals(Role.CUSTOMER)) {
            Customer customer = Customer.builder()
                    .address(createUserRequest.getAddress())
                    .nationalityId(createUserRequest.getNationalityId())
                    .user(user)
                    .build();
            user.setCustomers(List.of(customer));
        } else if (user.getRole().equals(Role.CORPORATE_CUSTOMER)) {
            CorporateCustomer corporateCustomer = CorporateCustomer.builder()
                    .companyName(createUserRequest.getCompanyName())
                    .taxNo(createUserRequest.getTaxNo())
                    .address(createUserRequest.getAddress())
                    .user(user)
                    .build();
            user.setCorporateCustomers(List.of(corporateCustomer));*/


    }
    @Override
    public String login(LoginUserRequest loginRequest) {
        System.out.println(loginRequest.getUsername() + " " + loginRequest.getPassword());
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        if(authentication.isAuthenticated())
        {
            return jwtService.generateToken(loginRequest.getUsername());
        }

        throw new RuntimeException("Kullanıcı adı ya da şifre yanlış");
    }
}