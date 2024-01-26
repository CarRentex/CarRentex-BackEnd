package com.Tobeto.RentaCar.service.dto.request.User;
import com.Tobeto.RentaCar.entities.concretes.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserRequest {


    @Email(message = "The string has to be a well-formed email address")
    @NotBlank(message = "This field cannot be left blank")
    private String email;

    @NotBlank(message = "This field cannot be left blank")
    private String password;

    private List<Role> roles;


}
