package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsByName(String name);
}
