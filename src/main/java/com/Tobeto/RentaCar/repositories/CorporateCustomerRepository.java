package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.concretes.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, Integer> {
    boolean existsByCompanyName (String name);

}
