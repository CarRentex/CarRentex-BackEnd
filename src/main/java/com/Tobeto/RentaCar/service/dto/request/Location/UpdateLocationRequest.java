package com.Tobeto.RentaCar.service.dto.request.Location;

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
    private String name;
}
