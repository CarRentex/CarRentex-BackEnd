package com.Tobeto.RentaCar.service.dto.request.Location;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLocationRequest {

    private int id;

    @Size(min = 2,  message = "Minimum 2 characters can be entered")
    @NotNull(message = "This field cannot be left blank")
    private String name;
}
