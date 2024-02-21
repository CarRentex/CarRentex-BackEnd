package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.service.abstracts.BrandService;
import com.Tobeto.RentaCar.service.dto.request.Brand.AddBrandRequest;
import com.Tobeto.RentaCar.service.dto.request.Brand.UpdateBrandRequest;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandListResponse;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandResponse;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandSearchListResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/brands")
@AllArgsConstructor
@CrossOrigin
public class BrandController {

    private final BrandService brandService;

/*    @GetMapping("search")
    public List<GetBrandSearchListResponse> search(@RequestParam String name){
        return this.brandService.search(name);
    }*/

    @GetMapping("/getAll")
    public List<GetBrandListResponse> getAll() {
        return this.brandService.getAll();
    }
    @GetMapping("/getById/{id}")
    public GetBrandResponse getById(@PathVariable int id){
        return this.brandService.getById(id);
    }
    @PostMapping("/create")
    public void create (@RequestBody @Valid AddBrandRequest addBrandRequest){
        this.brandService.create(addBrandRequest);
    }
    @PutMapping("/update")
    public void update(@RequestBody  @Valid UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }


}
