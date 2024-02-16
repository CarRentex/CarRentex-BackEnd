package com.Tobeto.RentaCar.service.dto.request.District;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDistrictRequest {

    @NotBlank(message = "This field cannot be left blank")
    private int cityId;

    @Size(min = 2,  message = "Minimum 2 characters can be entered")
    @NotBlank(message = "This field cannot be left blank")
    private String name;
}
