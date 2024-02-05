package com.Tobeto.RentaCar.service.abstracts;

import com.Tobeto.RentaCar.service.dto.request.User.DeleteUserRequest;
import com.Tobeto.RentaCar.service.dto.response.User.GetUserListResponse;
import com.Tobeto.RentaCar.service.dto.response.User.GetUserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void delete(int id);


    List<GetUserListResponse> getAll();

    GetUserResponse getById(int id);


}
