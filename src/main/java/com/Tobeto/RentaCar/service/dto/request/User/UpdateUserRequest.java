package com.Tobeto.RentaCar.service.dto.request.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    @Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 characters can be entered")
    @NotBlank(message = "This field cannot be left blank")
    private String name;
    @Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 characters can be entered")
    @NotBlank(message = "This field cannot be left blank")
    private String surname;
    @Size(min = 10, max = 10, message = "10 characters can be entered")
    @NotBlank(message = "This field cannot be left blank")
    //@Digits(integer = 10, fraction = 0, message = "Rakam girişi yapılmalıdır")
    private String gsm;
    @Email(message = "The string has to be a well-formed email address")
    @NotBlank(message = "This field cannot be left blank")
    private String email;
}
