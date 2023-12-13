package com.Tobeto.RentaCar.service.dto.response.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponse {
    private String name;
    private String surname;
    private String gsm;
    private String email;
}
