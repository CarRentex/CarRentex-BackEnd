package com.Tobeto.RentaCar.service.dto.request.Model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddModelRequest {

    private int brandId;
    @Size(min = 2, max = 30, message = "Minimum 2 characters can be entered")
    @NotBlank(message = "This field cannot be left blank")
    private String name;


}
