package com.Tobeto.RentaCar.service.dto.request.CorporateCustomer;

import com.Tobeto.RentaCar.entities.concretes.Role;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCorporateRequest {
    private int id;
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 20)
    private String companyName;


    @Email(message = "Invalid email address format. It must be in the format")
    @NotBlank(message = "Email cannot be blank")
    private String email;

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

    private boolean status;



}
