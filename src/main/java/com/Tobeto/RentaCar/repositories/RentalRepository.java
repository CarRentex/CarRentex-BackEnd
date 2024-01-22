package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.concretes.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {


}
