package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.service.abstracts.UserService;
import com.Tobeto.RentaCar.service.dto.request.User.DeleteUserRequest;
import com.Tobeto.RentaCar.service.dto.request.User.ResetPasswordRequest;
import com.Tobeto.RentaCar.service.dto.request.User.UpdatePasswordRequest;
import com.Tobeto.RentaCar.service.dto.response.User.GetUserListResponse;
import com.Tobeto.RentaCar.service.dto.response.User.GetUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    private final UserService userService;


    @GetMapping("/totalUsers")
    public int totalUsers() {
        return userService.totalUsers();
    }
    @PutMapping("/resetPassword")
    @ResponseStatus(code = HttpStatus.OK)
    public void resetPassword(@RequestBody @Valid ResetPasswordRequest resetPasswordRequest){
        userService.resetPassword(resetPasswordRequest);
    }

    @PutMapping("/updatePassword")
    @ResponseStatus(code = HttpStatus.OK)
    public void updatePassword(@RequestBody @Valid UpdatePasswordRequest updatePasswordRequest){
        userService.updatePassword(updatePasswordRequest);
    }
    @GetMapping("/getAll")
    @ResponseStatus(code = HttpStatus.OK)
    public List<GetUserListResponse> getAll(){
        return userService.getAll();
    }

    @GetMapping("/getById")
    @ResponseStatus(code = HttpStatus.OK)
    public GetUserResponse getById(@RequestParam int id){
        return  userService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable int id){
        userService.delete(id);
    }

}