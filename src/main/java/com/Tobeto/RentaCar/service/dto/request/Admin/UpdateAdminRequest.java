package com.Tobeto.RentaCar.service.dto.request.Admin;

import com.Tobeto.RentaCar.entities.concretes.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAdminRequest {

    private int id;

    @NotBlank(message = "Name cannot be blank")
    @Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ\\s]+$", message = "Name must consist of letters only.")
    @Size(min = 2, max = 20)
    private String name;

    @NotBlank(message = "Surname cannot be blank")
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ\\s]+$", message = "Surname must consist of letters only.")
    private String surname;

    @Email(message = "Invalid email address format. It must be in the format")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @Pattern(regexp = "[0-9]{11}", message = "Invalid national id format. It must be 11 digits.")
    private String nationality;

    @NotBlank(message = "PhoneNumber cannot be blank")
    @Pattern(regexp = "05[0-9]{9}", message = "Invalid phone number format. It must be in the format 05xxxxxxxxx.")
    private String phoneNumber;

    @NotBlank(message = "Address cannot be blank")
    private String address;

}
