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
    private String nationality;

    @NotBlank(message = "Password cannot be blank")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.*])(?=\\S+$).{8,}",
            message = "At least 8 characters\n" +
                    "\n" +
                    "Contains at least one digit\n" +
                    "\n" +
                    "Contains at least one lowercase and one uppercase letter\n" +
                    "\n" +
                    "Contains at least one special character from the set (@#%$^.*etc.)\n" +
                    "\n" +
                    "Does not contain spaces, tabs, etc.")
    private String password;

    @NotBlank(message = "PhoneNumber cannot be blank")
    @Pattern(regexp = "05[0-9]{9}", message = "Invalid phone number format. It must be in the format 05xxxxxxxxx.")
    private String phoneNumber;

    @NotNull(message = "City cannot be blank")
    private int cityId;

    @NotNull(message = "District cannot be blank")
    private int districtId;

    @NotBlank(message = "Address cannot be blank")
    private String address;

    @NotNull(message = "Role cannot be blank")
    private Role role;

}
