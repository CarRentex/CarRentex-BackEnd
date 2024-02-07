package com.Tobeto.RentaCar.rules.auth;

import com.Tobeto.RentaCar.entities.concretes.User;
import com.Tobeto.RentaCar.repositories.UserRepository;
import com.Tobeto.RentaCar.service.dto.request.User.CreateUserRequest;
import com.Tobeto.RentaCar.service.dto.request.User.LoginUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthRulesManager implements AuthRulesService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void checkIfEmailExists(String email) {
        if (userRepository.existsByEmail(email.trim()))
            throw new RuntimeException("Email is available in the system");
    }

    @Override
    public void checkIfPasswordMatch(String password, String rePassword) {
        if (!password.equals(rePassword)) {
            throw new RuntimeException("Passwords do not match");
        }
    }

    @Override
    public void checkLoginPassword(LoginUserRequest loginRequest, User user) {
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("kullanıcı adı veya şifre yanlış");
        }
    }

    @Override
    public void oldPasswordCheck(String password, String oldPassword) {
        if (!passwordEncoder.matches(oldPassword, password)) {
            throw new RuntimeException("old password is wrong");
        }
    }

    @Override
    public void newPasswordNotSameAsOldPassword(String password, String newPassword) {
        if (passwordEncoder.matches(newPassword, password)) {
            throw new RuntimeException("new password can not be same as old password");
        }
    }


}
