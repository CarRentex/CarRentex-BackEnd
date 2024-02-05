package com.Tobeto.RentaCar.service.dto.response.CorporateCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCorporateListResponse {
    private int id;
    private String companyName;
    private String taxNo;
    private String email;
    private String phoneNumber;
    private String address;

}
