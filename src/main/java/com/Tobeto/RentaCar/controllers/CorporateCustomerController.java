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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/corporate")
@AllArgsConstructor
@CrossOrigin
public class CorporateCustomerController {
    private final CorporateCustomerService corporateCustomerService;

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetCorporateListResponse> getAll() {
        return this.corporateCustomerService.getAll();
    }
    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetCorporateResponse getById(@PathVariable int id){
        return this.corporateCustomerService.getById(id);
    }
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create (@RequestBody @Valid AddCorporateRequest addCorporateRequest){
        this.corporateCustomerService.create(addCorporateRequest);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody  @Valid UpdateCorporateRequest updateCorporateRequest){
        this.corporateCustomerService.update(updateCorporateRequest);
    }
    @DeleteMapping("/{id}")
    // burayı araştır
    public void delete(@PathVariable int id){
        this.corporateCustomerService.delete(id);
    }

}
