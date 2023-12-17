package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.service.abstracts.ColorService;
import com.Tobeto.RentaCar.service.dto.request.Color.AddColorRequest;
import com.Tobeto.RentaCar.service.dto.request.Color.UpdateColorRequest;
import com.Tobeto.RentaCar.service.dto.response.Color.GetColorListResponse;
import com.Tobeto.RentaCar.service.dto.response.Color.GetColorResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/colors")
@AllArgsConstructor
public class ColorController {
    private final ColorService colorService;

    @GetMapping
    public List<GetColorListResponse> getAll() {
        return this.colorService.getAll();
    }
    @GetMapping("{id}")
    public GetColorResponse getById(@PathVariable int id){
        return this.colorService.getById(id);
    }
    @PostMapping("/create")
    public void add(@RequestBody @Valid AddColorRequest addColorRequest){
        this.colorService.add(addColorRequest);
    }
    @PutMapping("/update")
    public void update(@RequestBody  @Valid UpdateColorRequest updateColorRequest){
        this.colorService.update(updateColorRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.colorService.delete(id);
    }

}
