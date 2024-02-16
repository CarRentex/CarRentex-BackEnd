package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.service.abstracts.AuthService;
import com.Tobeto.RentaCar.service.dto.request.User.CreateUserRequest;
import com.Tobeto.RentaCar.service.dto.request.User.LoginUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auths")
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signIn")
    @ResponseStatus(HttpStatus.OK)
    public String signIn(@RequestBody LoginUserRequest loginRequest) {
        System.out.println("ejkshtklsjetklsjrtşlsjrşoyljsnrlkhjlsş");
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody CreateUserRequest request) {
        authService.register(request);
    }

    @PostMapping("/signOut")
    @ResponseStatus(HttpStatus.OK)
    public void signOut(@RequestParam int id) {
        authService.logout(id);
    }


}
