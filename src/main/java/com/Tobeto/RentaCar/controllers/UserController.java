package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.service.abstracts.UserService;
import com.Tobeto.RentaCar.service.dto.request.Rental.AddRentalRequest;
import com.Tobeto.RentaCar.service.dto.request.Rental.UpdateRentalRequest;
import com.Tobeto.RentaCar.service.dto.request.User.AddUserRequest;
import com.Tobeto.RentaCar.service.dto.request.User.UpdateUserRequest;
import com.Tobeto.RentaCar.service.dto.response.Rental.GetRentalListResponse;
import com.Tobeto.RentaCar.service.dto.response.Rental.GetRentalResponse;
import com.Tobeto.RentaCar.service.dto.response.User.GetUserListResponse;
import com.Tobeto.RentaCar.service.dto.response.User.GetUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<GetUserListResponse> getAll() {
        return userService.getAll();
    }

    @GetMapping("{id}")
    public GetUserResponse getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody @Valid AddUserRequest userRequest) {
        userService.create(userRequest);
    }
    @PutMapping("/update")
    public void update(@RequestBody  @Valid UpdateUserRequest userRequest){
        userService.update(userRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }


}
