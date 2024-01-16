package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.concretes.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
