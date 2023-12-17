package com.Tobeto.RentaCar.service.abstracts;

import com.Tobeto.RentaCar.service.dto.request.User.AddUserRequest;
import com.Tobeto.RentaCar.service.dto.request.User.UpdateUserRequest;
import com.Tobeto.RentaCar.service.dto.response.User.GetUserListResponse;
import com.Tobeto.RentaCar.service.dto.response.User.GetUserResponse;

import java.util.List;

public interface UserService {
    List<GetUserListResponse> getAll();
    GetUserResponse getById(int id);
    void create(AddUserRequest userRequest);
    void update(UpdateUserRequest userRequest);
    void delete(int id);
}
