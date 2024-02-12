package com.Tobeto.RentaCar.service.dto.response.Brand;

import com.Tobeto.RentaCar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBrandListApi {
    private String name;
    private List<Model> models;
}
