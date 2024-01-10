package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.concretes.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
// kullanım dışı örnek
//    @Query("SELECT c.kilometer FROM Car c " +
//            "WHERE c.id = :carId")
//    public int getRentKilometer(int carId);

}
