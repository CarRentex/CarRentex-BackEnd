package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.entities.concretes.Car;
import com.Tobeto.RentaCar.entities.concretes.Category;
import com.Tobeto.RentaCar.service.abstracts.CarService;
import com.Tobeto.RentaCar.service.dto.request.Car.AddCarRequest;
import com.Tobeto.RentaCar.service.dto.request.Car.UpdateCarRequest;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarListResponse;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarResponse;
import jakarta.persistence.Tuple;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
@CrossOrigin
public class CarController {

    private final CarService carService;


  /*  @GetMapping("search")
    public List<GetCarListResponse> search(@RequestParam String name){
        return carService.search(name);


    }*/

    @GetMapping("/filter")
    public List<GetCarListResponse> filterCars(
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Integer modelId) {
        return carService.filterCars(minPrice, maxPrice, modelId);
    }

    @GetMapping("/category")
    public List<GetCarListResponse> getCategorizeCars(@RequestParam Category  category) {
        return carService.getCategorizeCars(category);
    }

    @GetMapping("/available")
    public List<GetCarListResponse> getAvailableCars(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return carService.getAvailableCars(startDate, endDate);
    }

    @GetMapping
    public List<GetCarListResponse> getAll() {
        return carService.getAll();
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id) {
        return carService.getById(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody AddCarRequest addCarRequest) throws IOException {
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
