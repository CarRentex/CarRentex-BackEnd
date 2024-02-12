package com.Tobeto.RentaCar.service.abstracts;

import com.Tobeto.RentaCar.service.dto.request.User.CreateUserRequest;
import com.Tobeto.RentaCar.service.dto.request.User.LoginUserRequest;

public interface AuthService {
    void register(CreateUserRequest createUserRequest);
    String login(LoginUserRequest loginRequest);

    void logout(int id);
}