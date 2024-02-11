package com.Tobeto.RentaCar.service.dto.request.CorporateCustomer;

import com.Tobeto.RentaCar.entities.concretes.Role;
import com.Tobeto.RentaCar.service.dto.request.User.CreateUserRequest;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCorporateRequest {
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 20)
    private String companyName;


    @Email(message = "Invalid email address format. It must be in the format")
    @NotBlank(message = "Email cannot be blank")
    private String email;

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

    @NotBlank(message = "TaxNo cannot be blank")
    @Pattern(regexp = "^[0-9]+$", message = "Invalid TaxNo No digit format")
    private String taxNo;

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
