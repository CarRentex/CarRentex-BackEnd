package com.Tobeto.RentaCar.service.dto.request.User;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserRequest {
    private String name;
    private String surname;
    private String gsm;
    private String email;
}
