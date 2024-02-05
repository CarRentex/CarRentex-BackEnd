package com.Tobeto.RentaCar.service.dto.request.Customer;

import com.Tobeto.RentaCar.entities.concretes.Role;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCustomerRequest {
    String name;

    String surname;

    String nationality;

    String address;

    String phoneNumber;

    @Email(message = "Geçersiz e-posta adresi formatı")
    @NotBlank(message = "E-posta boş olamaz")
    private String email;


    private String password;

    @NotNull()
    private Role role = Role.CUSTOMER; // list<Role > idi düzelttim dikkat

}
