package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
