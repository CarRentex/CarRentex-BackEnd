package com.Tobeto.RentaCar.service.dto.response.Admin;

import com.Tobeto.RentaCar.entities.concretes.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAdminListResponse {
    private int id;
    private String name;
    private String surname;
    private String nationality;
    private String phoneNumber;
    private String cityName;
    private String districtName;
    private String address;
    private String email;
    private boolean status;
}
