package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.service.abstracts.DistrictService;
import com.Tobeto.RentaCar.service.dto.response.District.GetDistrictResponse;
import com.Tobeto.RentaCar.service.dto.response.District.GetListDistrictResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/districts")
@AllArgsConstructor
@CrossOrigin
public class DistrictController {
    private final DistrictService districtService;

    @GetMapping("/getAll")
    public List<GetListDistrictResponse> getAll() {
        return districtService.getAll();
    }

    @GetMapping("/getById/{id}")
    public List<GetDistrictResponse> getById(@PathVariable int id) {
        return districtService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        districtService.delete(id);
    }

}
