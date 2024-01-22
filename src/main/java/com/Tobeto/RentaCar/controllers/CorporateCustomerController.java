package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.service.abstracts.BrandService;
import com.Tobeto.RentaCar.service.abstracts.CorporateCustomerService;
import com.Tobeto.RentaCar.service.dto.request.Brand.AddBrandRequest;
import com.Tobeto.RentaCar.service.dto.request.Brand.UpdateBrandRequest;
import com.Tobeto.RentaCar.service.dto.request.CorporateCustomer.AddCorporateRequest;
import com.Tobeto.RentaCar.service.dto.request.CorporateCustomer.UpdateCorporateRequest;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandListResponse;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandResponse;
import com.Tobeto.RentaCar.service.dto.response.CorporateCustomer.GetCorporateListResponse;
import com.Tobeto.RentaCar.service.dto.response.CorporateCustomer.GetCorporateResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/corporatecustomers")
@AllArgsConstructor
public class CorporateCustomerController {
    private final CorporateCustomerService customerService;

    @GetMapping
    public List<GetCorporateListResponse> getAll() {
        return this.customerService.getAll();
    }
    @GetMapping("{id}")
    public GetCorporateResponse getById(@PathVariable int id){
        return this.customerService.getById(id);
    }
    @PostMapping("/create")
    public void create (@RequestBody @Valid AddCorporateRequest addCorporateRequest){
        this.customerService.create(addCorporateRequest);
    }
    @PutMapping("/update")
    public void update(@RequestBody  @Valid UpdateCorporateRequest updateCorporateRequest){
        this.customerService.update(updateCorporateRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.customerService.delete(id);
    }

}
