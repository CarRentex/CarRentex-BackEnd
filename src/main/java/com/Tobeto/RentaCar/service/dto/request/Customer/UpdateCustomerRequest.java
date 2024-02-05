package com.Tobeto.RentaCar.service.dto.request.Customer;

import com.Tobeto.RentaCar.entities.concretes.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerRequest {
    private int id;
    @NotNull(message = "Ad boş olamaz")
    @NotBlank(message = "Ad boş olamaz")
    String name;

    String surname;

    String nationalityId;

    String address;

    String phoneNumber;

    @Email(message = "Geçersiz e-posta adresi formatı")
    @NotBlank(message = "E-posta boş olamaz")
    private String email;


    @NotNull()
    private Role roles = Role.CUSTOMER; // list<Role > idi düzelttim dikkat
}
