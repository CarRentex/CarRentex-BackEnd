package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.service.abstracts.LocationService;
import com.Tobeto.RentaCar.service.dto.request.Location.CreateLocationRequest;
import com.Tobeto.RentaCar.service.dto.response.Location.GetListLocationResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/location")
@AllArgsConstructor
@CrossOrigin
public class LocationController {
private final LocationService locationService;

    @GetMapping
    public List<GetListLocationResponse> getAll() {
        return this.locationService.getAll();
    }

    @GetMapping("{id}")
    public GetListLocationResponse getById(@PathVariable int id){
        return this.locationService.getById(id);
    }

    @PostMapping("/create")
    public void create (@RequestBody @Valid CreateLocationRequest createLocationRequest){
        this.locationService.create(createLocationRequest);
    }

/*    @PutMapping("/update")
    public void update(@RequestBody  @Valid UpdateLocationRequest updateLocationRequest){
        this.locationService.update(updateLocationRequest);
    }*/
/*
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.locationService.delete(id);
    }*/
}
