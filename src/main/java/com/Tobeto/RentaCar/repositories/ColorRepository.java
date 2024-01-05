package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.concretes.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Integer> {
    boolean existsByName (String name);
}
