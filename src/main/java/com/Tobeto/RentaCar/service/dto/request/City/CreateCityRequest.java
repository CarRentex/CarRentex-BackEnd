package com.Tobeto.RentaCar.service.dto.request.City;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCityRequest {
    @Size(min = 2,  message = "Minimum 2 characters can be entered")
    @NotBlank(message = "This field cannot be left blank")
    private String name;
}
