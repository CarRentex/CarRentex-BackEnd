package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
