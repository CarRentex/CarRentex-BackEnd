package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.service.abstracts.RentalService;
import com.Tobeto.RentaCar.service.dto.request.Car.AddCarRequest;
import com.Tobeto.RentaCar.service.dto.request.Car.UpdateCarRequest;
import com.Tobeto.RentaCar.service.dto.request.Rental.AddRentalRequest;
import com.Tobeto.RentaCar.service.dto.request.Rental.UpdateRentalRequest;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarListResponse;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarResponse;
import com.Tobeto.RentaCar.service.dto.response.Rental.GetRentalListResponse;
import com.Tobeto.RentaCar.service.dto.response.Rental.GetRentalResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
@AllArgsConstructor
public class RentalController {
    private final RentalService rentalService;
    @GetMapping
    public List<GetRentalListResponse> getAll() {
        return rentalService.getAll();
    }

    @GetMapping("{id}")
    public GetRentalResponse getById(@PathVariable int id) {
        return rentalService.getById(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody @Valid AddRentalRequest rentalRequest) {
        rentalService.create(rentalRequest);
    }
    @PutMapping("/update")
    public void update(@RequestBody  @Valid UpdateRentalRequest rentalRequest){
        rentalService.update(rentalRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalService.delete(id);
    }

}
