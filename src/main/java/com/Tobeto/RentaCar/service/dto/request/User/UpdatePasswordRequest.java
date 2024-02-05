package com.Tobeto.RentaCar.service.dto.request.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePasswordRequest {
    private int id;

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
    private String confirmPassword;
}
