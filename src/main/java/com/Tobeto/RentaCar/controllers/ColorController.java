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
@CrossOrigin
public class ColorController {
    private final ColorService colorService;

    @GetMapping("/getAll")
    public List<GetColorListResponse> getAll() {
        return this.colorService.getAll();
    }
    @GetMapping("/getById/{id}")
    public GetColorResponse getById(@PathVariable int id){
        return this.colorService.getById(id);
    }
    @PostMapping("/create")
    public void create (@RequestBody @Valid AddColorRequest addColorRequest){
        this.colorService.create(addColorRequest);
    }
    @PutMapping("/update")
    public void update(@RequestBody  @Valid UpdateColorRequest updateColorRequest){
        this.colorService.update(updateColorRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.colorService.delete(id);
    }

}
