/*
package com.Tobeto.RentaCar.core.services;

import com.Tobeto.RentaCar.entities.concretes.Brand;
import com.Tobeto.RentaCar.entities.concretes.Model;
import com.Tobeto.RentaCar.repositories.BrandRepository;
import com.Tobeto.RentaCar.repositories.ModelRepository;
import com.Tobeto.RentaCar.service.abstracts.BrandService;
import com.Tobeto.RentaCar.service.abstracts.ModelService;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandListApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BrandAndModelTestApi {

    private static final String JSON_FILE_PATH = "/Users/burakkarlidag/Desktop/CarRentex-BackEnd/car-list.json";

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;

    @GetMapping("/import-brands-and-models")
    public String importBrandsAndModels() {
        List<GetBrandListApi> brandDTOList = readJsonData();

        if (brandDTOList != null) {
            for (GetBrandListApi brandDTO : brandDTOList) {
                // Marka ekleyin
                Brand brand = new Brand();
                brand.setName(brandDTO.getName());
                brandRepository.save(brand);

                // Modelleri ekleyin
                for (Model modelDTO : brandDTO.getModels()) {
                    Model model = new Model();
                    model.setName(modelDTO.getName());
                    model.setBrand(brand);
                    modelRepository.save(model);
                }
            }
            return "Brands and Models imported successfully!";
        } else {
            return "Error importing Brands and Models!";
        }
    }


    private List<GetBrandListApi> readJsonData() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            GetBrandListApi[] brandsArray = objectMapper.readValue(new File(JSON_FILE_PATH), GetBrandListApi[].class);
            return Arrays.asList(brandsArray);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}*/
