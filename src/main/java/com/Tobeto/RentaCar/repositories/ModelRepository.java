package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
