package com.Tobeto.RentaCar.service.dto.response.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserListResponse {
    private int id;
    private String email;
    private String phoneNumber;
    private String address;
    private String role;
    private String createdAt;
    private String updatedAt;

}
