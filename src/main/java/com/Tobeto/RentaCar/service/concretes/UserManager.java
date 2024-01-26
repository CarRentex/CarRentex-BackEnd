package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.concretes.User;
import com.Tobeto.RentaCar.repositories.UserRepository;
import com.Tobeto.RentaCar.rules.user.UserBusinessRuleService;
import com.Tobeto.RentaCar.service.abstracts.UserService;
import com.Tobeto.RentaCar.service.dto.request.User.AddUserRequest;
import com.Tobeto.RentaCar.service.dto.request.User.UpdateUserRequest;
import com.Tobeto.RentaCar.service.dto.response.User.GetUserListResponse;
import com.Tobeto.RentaCar.service.dto.response.User.GetUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    @Override
    public void register(AddUserRequest createUserRequest) {
        if(existEmail(createUserRequest.getEmail())){
            throw new RuntimeException("User already saved");
        }
        User user = User.builder()
                .email(createUserRequest.getEmail())
                .authorities(createUserRequest.getRoles())
                .password(passwordEncoder.encode(createUserRequest.getPassword()))
                .build();
        userRepository.save(user);
    }

    @Override
    public String login(AddUserRequest loginRequest) {
        return "";
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("No user found"));
    }

    private boolean existEmail(String email){
        return userRepository.existsUserByEmail(email);
    }

}