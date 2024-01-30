package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.service.abstracts.AuthService;
import com.Tobeto.RentaCar.service.dto.request.User.CreateUserRequest;
import com.Tobeto.RentaCar.service.dto.request.User.LoginUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody LoginUserRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody CreateUserRequest request) {
        authService.register(request);
    }
}
