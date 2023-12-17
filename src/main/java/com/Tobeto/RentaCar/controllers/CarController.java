package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.entities.Brand;
import com.Tobeto.RentaCar.entities.Car;
import com.Tobeto.RentaCar.service.abstracts.BrandService;
import com.Tobeto.RentaCar.service.abstracts.CarService;
import com.Tobeto.RentaCar.service.dto.request.Brand.AddBrandRequest;
import com.Tobeto.RentaCar.service.dto.request.Brand.UpdateBrandRequest;
import com.Tobeto.RentaCar.service.dto.request.Car.AddCarRequest;
import com.Tobeto.RentaCar.service.dto.request.Car.UpdateCarRequest;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandResponse;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarListResponse;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<GetCarListResponse> getAll() {
        return carService.getAll();
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id) {
        return carService.getById(id);
    }

    @PostMapping("/create")
    public void create (@RequestBody @Valid AddCarRequest addCarRequest) {
        carService.create(addCarRequest);
    }
    @PutMapping("/update")
    public void update(@RequestBody  @Valid UpdateCarRequest updateCarRequest){
        carService.update(updateCarRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carService.delete(id);
    }

}
