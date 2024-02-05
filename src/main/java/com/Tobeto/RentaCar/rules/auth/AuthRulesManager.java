package com.Tobeto.RentaCar.rules.auth;

import com.Tobeto.RentaCar.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthRulesManager implements AuthRulesService{
    private final UserRepository userRepository;


    @Override
    public void checkIfEmailExists(String email) {
        if (userRepository.existsByEmail(email.trim()))
            throw new RuntimeException("email is available in the system");
    }
}
