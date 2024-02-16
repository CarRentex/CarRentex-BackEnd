package com.Tobeto.RentaCar.entities.concretes;

import com.Tobeto.RentaCar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "invoices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice extends BaseEntity {
    @Column(name = "invoice_no")
    private String invoiceNo;
    @Column(name = "discount_rate",length =10)
    private Float discountRate;
    @Column(name = "tax_rate")
    private Float taxRate;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;
}
