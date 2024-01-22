package com.Tobeto.RentaCar.service.dto.response.Invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInvoiceListResponse {
    //örnek olarak invoiceNo, discountRate, taxRate, rentalId gibi alanlar eklenebilir.
    private String customerName;
    private String brandName;
    private String rentDate;
    private String returnDate;
    private double totalPrice;
}
