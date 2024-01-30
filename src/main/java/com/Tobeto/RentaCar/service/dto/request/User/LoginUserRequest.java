package com.Tobeto.RentaCar.service.dto.request.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginUserRequest {
    private String username;
    private String password;
}
