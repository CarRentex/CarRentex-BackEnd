package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.service.abstracts.ModelService;
import com.Tobeto.RentaCar.service.dto.request.Model.AddModelRequest;
import com.Tobeto.RentaCar.service.dto.request.Model.UpdateModelRequest;
import com.Tobeto.RentaCar.service.dto.response.Model.GetModelByBrandId;
import com.Tobeto.RentaCar.service.dto.response.Model.GetModelListResponse;
import com.Tobeto.RentaCar.service.dto.response.Model.GetModelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/models")
@AllArgsConstructor
@CrossOrigin
public class ModelController {
    private final ModelService modelService;

    @GetMapping("/getByBrandId")
    public List<GetModelByBrandId> getByBrandId(@RequestParam int id){
        return this.modelService.getByBrandId(id);
    }
    @GetMapping("/getAll")
    public List<GetModelListResponse> getAll() {
        return this.modelService.getAll();
    }
    @GetMapping("/getById/{id}")
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
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.modelService.delete(id);
    }
}
