package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
    boolean existsByName (String name);
}
