package com.Tobeto.RentaCar.service.dto.response.CorporateCustomer;

import com.Tobeto.RentaCar.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCorporateListResponse {
    private String companyName;
    private String taxNo;

}
