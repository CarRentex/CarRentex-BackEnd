package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.entities.Model;
import com.Tobeto.RentaCar.service.abstracts.ModelService;
import com.Tobeto.RentaCar.service.dto.request.Brand.AddBrandRequest;
import com.Tobeto.RentaCar.service.dto.request.Brand.UpdateBrandRequest;
import com.Tobeto.RentaCar.service.dto.request.Model.AddModelRequest;
import com.Tobeto.RentaCar.service.dto.request.Model.UpdateModelRequest;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandResponse;
import com.Tobeto.RentaCar.service.dto.response.Model.GetModelListResponse;
import com.Tobeto.RentaCar.service.dto.response.Model.GetModelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/models")
@AllArgsConstructor

public class ModelController {
    private final ModelService modelService;
    @GetMapping
    public List<GetModelListResponse> getAll() {
        return this.modelService.getAll();
    }
    @GetMapping("{id}")
    public GetModelResponse getById(@PathVariable int id){
        return this.modelService.getById(id);
    }
    @PostMapping("/create")
    public void create (@RequestBody @Valid AddModelRequest addModelRequest){
        this.modelService.create(addModelRequest);
    }
    @PutMapping("/update")
    public void update(@RequestBody  @Valid UpdateModelRequest updateModelRequest){
        this.modelService.update(updateModelRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.modelService.delete(id);
    }
}
