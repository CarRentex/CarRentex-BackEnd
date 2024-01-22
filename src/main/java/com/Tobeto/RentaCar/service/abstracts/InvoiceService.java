package com.Tobeto.RentaCar.service.abstracts;

import com.Tobeto.RentaCar.service.dto.request.Invoice.AddInvoiceRequest;
import com.Tobeto.RentaCar.service.dto.request.Invoice.UpdateInvoiceRequest;
import com.Tobeto.RentaCar.service.dto.response.Invoice.GetInvoiceListResponse;
import com.Tobeto.RentaCar.service.dto.response.Invoice.GetInvoiceResponse;

import java.util.List;

public interface InvoiceService {
    List<GetInvoiceListResponse> getAll();
    GetInvoiceResponse getById(int id);
    void create (AddInvoiceRequest addInvoiceRequest);
    void update(UpdateInvoiceRequest invoiceRequest);
    void delete(int id);
}
