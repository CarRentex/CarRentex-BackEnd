package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
// kullanım dışı örnek
//    @Query("SELECT c.kilometer FROM Car c " +
//            "WHERE c.id = :carId")
//    public int getRentKilometer(int carId);

}
