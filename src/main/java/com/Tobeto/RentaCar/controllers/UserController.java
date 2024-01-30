package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.core.services.JwtService;
import com.Tobeto.RentaCar.service.abstracts.UserService;
import com.Tobeto.RentaCar.service.dto.request.User.DeleteUserRequest;
import com.Tobeto.RentaCar.service.dto.request.User.UpdateUserRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    private final UserService userService;

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody @Valid UpdateUserRequest updateUserRequest){
        userService.update(updateUserRequest);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@RequestBody @Valid DeleteUserRequest deleteUserRequest){
        userService.delete(deleteUserRequest);
    }

}