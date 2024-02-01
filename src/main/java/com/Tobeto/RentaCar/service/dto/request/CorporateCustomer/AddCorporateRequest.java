package com.Tobeto.RentaCar.service.dto.request.CorporateCustomer;

import com.Tobeto.RentaCar.service.dto.request.User.CreateUserRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCorporateRequest {
    private String companyName;
    private String taxNo;

}
