package com.Tobeto.RentaCar.service.dto.request.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class DeleteUserRequest {
    @NotBlank(message = "Id cannot be blank")
    private int id;
}