package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByFirstName (String name);
    boolean existsByLastName (String name);
}
