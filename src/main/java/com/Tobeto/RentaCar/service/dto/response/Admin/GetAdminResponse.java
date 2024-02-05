package com.Tobeto.RentaCar.service.dto.response.Admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAdminResponse {
    private String name;
    private String surname;
    private String phoneNumber;
    private String address;
    private String email;
}