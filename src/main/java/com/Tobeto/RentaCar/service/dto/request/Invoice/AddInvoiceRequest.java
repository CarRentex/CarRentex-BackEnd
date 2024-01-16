package com.Tobeto.RentaCar.service.dto.request.Invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddInvoiceRequest {
    private String invoiceNo;
    private Float discountRate;
    private Float taxRate;
    private int rentalId;
}
