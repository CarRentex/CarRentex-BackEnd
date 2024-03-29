package com.Tobeto.RentaCar.service.dto.response.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponse {
    private String email;
    private String phoneNumber;
    private String address;
    private String role;
    private String createdAt;
    private String updatedAt;
    private boolean isActive;
    private String cityName;
    private String districtName;

}

