package com.Tobeto.RentaCar.service.dto.request.User;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class DeleteUserRequest {
    @Positive(message = "Lütfen geçerli bir id giriniz!!!")
    private int id;
}