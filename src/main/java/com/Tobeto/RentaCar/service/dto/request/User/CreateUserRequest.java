package com.Tobeto.RentaCar.service.dto.request.User;

import com.Tobeto.RentaCar.entities.concretes.Role;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    String name;

    String surname;

    String nationalityId;

    String address;

    String companyName;

    String taxNo;

    String phoneNumber;

    @Email(message = "Geçersiz e-posta adresi formatı")
    @NotBlank(message = "E-posta boş olamaz")
    private String email;

    private String password;


    @NotNull()
    private Role roles; // list<Role > idi düzelttim dikkat

}