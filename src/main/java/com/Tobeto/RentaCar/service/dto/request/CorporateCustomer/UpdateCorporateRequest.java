package com.Tobeto.RentaCar.service.dto.request.CorporateCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCorporateRequest {
    private int id;
    private String companyName;
    private String taxNo;
    private String address;
    private String phoneNumber;
    private String email;

}
