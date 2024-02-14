package com.Tobeto.RentaCar.service.dto.response.Location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListLocationResponse {
    private Integer id;
    private String location;
}
