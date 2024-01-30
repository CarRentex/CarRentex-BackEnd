package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.service.abstracts.CustomerService;
import com.Tobeto.RentaCar.service.dto.request.Color.AddColorRequest;
import com.Tobeto.RentaCar.service.dto.request.Color.UpdateColorRequest;
import com.Tobeto.RentaCar.service.dto.request.Customer.AddCustomerRequest;
import com.Tobeto.RentaCar.service.dto.request.Customer.UpdateCustomerRequest;
import com.Tobeto.RentaCar.service.dto.response.Color.GetColorListResponse;
import com.Tobeto.RentaCar.service.dto.response.Color.GetColorResponse;
import com.Tobeto.RentaCar.service.dto.response.Customer.GetCustomerListResponse;
import com.Tobeto.RentaCar.service.dto.response.Customer.GetCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<GetCustomerListResponse> getAll() {
        return this.customerService.getAll();
    }
    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id){
        return this.customerService.getById(id);
    }
    @PostMapping("/create")
    public void create (@RequestBody @Valid AddCustomerRequest addCustomerRequest){
        this.customerService.create(addCustomerRequest);
    }
    @PutMapping("/update")
    public void update(@RequestBody  @Valid UpdateCustomerRequest updateCustomerRequest){
        this.customerService.update(updateCustomerRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.customerService.delete(id);
    }


}
