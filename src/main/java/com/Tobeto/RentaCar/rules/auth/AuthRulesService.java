package com.Tobeto.RentaCar.rules.auth;

import com.Tobeto.RentaCar.entities.concretes.User;
import com.Tobeto.RentaCar.service.dto.request.User.CreateUserRequest;
import com.Tobeto.RentaCar.service.dto.request.User.LoginUserRequest;

public interface AuthRulesService {
    void checkIfEmailExists(String email);
    //void checkIfPasswordMatch(String password, String rePassword);
    void checkIfPasswordMatch(String password, String rePassword);

    void checkLoginPassword(LoginUserRequest loginRequest, User user);

    void oldPasswordCheck(String password, String oldPassword);

    void newPasswordNotSameAsOldPassword(String password, String newPassword);

}
