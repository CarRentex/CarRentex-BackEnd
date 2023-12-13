package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.entities.Brand;
import com.Tobeto.RentaCar.service.abstracts.BrandService;
import com.Tobeto.RentaCar.service.dto.request.Brand.AddBrandRequest;
import com.Tobeto.RentaCar.service.dto.request.Brand.UpdateBrandRequest;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarController {

    private final BrandService brandService;
    @GetMapping
    public List<Brand> getAll() {
        return this.brandService.getAll();
    }
    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id){
        return this.brandService.getById(id);
    }
    @PostMapping
    public void add(@RequestBody @Valid AddBrandRequest addBrandRequest){
        this.brandService.add(addBrandRequest);
    }
    @PutMapping("{id}")
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest, @PathVariable int id){
        this.brandService.update(updateBrandRequest,id);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }

}
