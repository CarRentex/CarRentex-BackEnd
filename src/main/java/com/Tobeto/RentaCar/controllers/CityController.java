package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.service.abstracts.CityService;
import com.Tobeto.RentaCar.service.dto.response.City.GetAllCityAndDistirctResponse;
import com.Tobeto.RentaCar.service.dto.response.City.GetAllCityResponse;
import com.Tobeto.RentaCar.service.dto.response.City.GetCityResponse;
import com.Tobeto.RentaCar.service.dto.response.City.GetListCityResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cities")
@AllArgsConstructor
@CrossOrigin
public class CityController {
    private final CityService cityService;

    @GetMapping("/getAll")
    public List<GetAllCityAndDistirctResponse> getAll() {
        return cityService.getAll();
    }

    @GetMapping("/getAllCities")
    public List<GetAllCityResponse> getAllCity() {
        return cityService.getAllCity();
    }

    @GetMapping("/getById/{id}")
    public GetCityResponse getById(@PathVariable int id) {
        return cityService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        cityService.delete(id);
    }
}
