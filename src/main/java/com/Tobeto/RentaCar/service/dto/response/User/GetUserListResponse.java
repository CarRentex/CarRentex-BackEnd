package com.Tobeto.RentaCar.service.dto.response.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserListResponse {
    private String email;
    private String password;
}
