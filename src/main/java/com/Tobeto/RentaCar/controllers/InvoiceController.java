package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.service.abstracts.InvoiceService;
import com.Tobeto.RentaCar.service.dto.request.Invoice.AddInvoiceRequest;
import com.Tobeto.RentaCar.service.dto.request.Invoice.UpdateInvoiceRequest;
import com.Tobeto.RentaCar.service.dto.response.Invoice.GetInvoiceListResponse;
import com.Tobeto.RentaCar.service.dto.response.Invoice.GetInvoiceResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/invoice")
@AllArgsConstructor
public class InvoiceController {
    private final InvoiceService invoiceService;

    @GetMapping
    public List<GetInvoiceListResponse> getAll() {
        return this.invoiceService.getAll();
    }
    @GetMapping("{id}")
    public GetInvoiceResponse getById(@PathVariable int id){
        return this.invoiceService.getById(id);
    }
    @PostMapping("/create")
    public void create (@RequestBody @Valid AddInvoiceRequest addInvoiceRequest){
        this.invoiceService.create(addInvoiceRequest);
    }
    @PutMapping("/update")
    public void update(@RequestBody  @Valid UpdateInvoiceRequest updateInvoiceRequest){
        this.invoiceService.update(updateInvoiceRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.invoiceService.delete(id);
    }

}
