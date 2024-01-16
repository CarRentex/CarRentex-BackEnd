package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.concretes.Invoice;
import com.Tobeto.RentaCar.repositories.InvoiceRepository;
import com.Tobeto.RentaCar.rules.invoice.InvoiceBusinessRuleManager;
import com.Tobeto.RentaCar.service.abstracts.InvoiceService;
import com.Tobeto.RentaCar.service.dto.request.Invoice.AddInvoiceRequest;
import com.Tobeto.RentaCar.service.dto.request.Invoice.UpdateInvoiceRequest;
import com.Tobeto.RentaCar.service.dto.response.Invoice.GetInvoiceListResponse;
import com.Tobeto.RentaCar.service.dto.response.Invoice.GetInvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final ModelMapperService mapperService;
    private final InvoiceBusinessRuleManager invoiceBusinessRuleManager;

    @Override
    public List<GetInvoiceListResponse> getAll() {
        List<GetInvoiceListResponse> getInvoiceListResponses = invoiceRepository.findAll().stream()
                .map(invoice -> mapperService.forResponse().map(invoice, GetInvoiceListResponse.class))
                .collect(Collectors.toList());
        return getInvoiceListResponses;
    }

    @Override
    public GetInvoiceResponse getById(int id) {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow();
        GetInvoiceResponse response = mapperService.forResponse().map(invoice, GetInvoiceResponse.class);
        return response;
    }

    @Override
    public void create(AddInvoiceRequest addInvoiceRequest) {
        Invoice invoice = mapperService.forRequest().map(addInvoiceRequest, Invoice.class);
        invoiceRepository.save(invoice);
    }

    @Override
    public void update(UpdateInvoiceRequest invoiceRequest) {
        Invoice invoice = mapperService.forRequest().map(invoiceRequest, Invoice.class);
        invoiceRepository.save(invoice);
    }

    @Override
    public void delete(int id) {
        invoiceRepository.deleteById(id);
    }
}
