package com.Tobeto.RentaCar.service.dto.request.Customer;

import com.Tobeto.RentaCar.entities.concretes.Role;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerRequest {

    @NotNull(message = "Id cannot be blank")
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

    @Pattern(regexp = "^[0-9]{11}$", message = "Invalid NationalityId No format")
    private String nationalityId;

    @NotBlank(message = "PhoneNumber cannot be blank")
    @Pattern(regexp = "05[0-9]{9}", message = "Invalid phone number format. It must be in the format 05xxxxxxxxx.")
    private String phoneNumber;

    @NotBlank(message = "Address cannot be blank")
    private String address;

}
