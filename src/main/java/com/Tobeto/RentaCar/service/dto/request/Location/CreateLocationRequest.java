package com.Tobeto.RentaCar.service.dto.request.Location;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateLocationRequest {

    @Size(min = 2,  message = "Minimum 2 characters can be entered")
    @NotBlank(message = "This field cannot be left blank")
    private String name;
}
