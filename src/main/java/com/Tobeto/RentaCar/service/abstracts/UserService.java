package com.Tobeto.RentaCar.service.abstracts;

import com.Tobeto.RentaCar.entities.concretes.User;
import com.Tobeto.RentaCar.service.dto.request.User.CreateUserRequest;
import com.Tobeto.RentaCar.service.dto.request.User.DeleteUserRequest;
import com.Tobeto.RentaCar.service.dto.request.User.UpdateUserRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void add(User user);
    void update(UpdateUserRequest updateUserRequest);
    void delete(DeleteUserRequest deleteUserRequest);

}
