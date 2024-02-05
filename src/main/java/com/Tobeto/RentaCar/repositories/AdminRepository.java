package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.concretes.Admin;
import com.Tobeto.RentaCar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    boolean existsByName(String name);
}
