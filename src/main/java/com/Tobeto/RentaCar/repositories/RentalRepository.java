package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

    @Query("SELECT c.kilometer FROM Car c " +
            "WHERE c.id = :carId")
    public int getRentKilometer(int carId);


    //@Query("SELECT r FROM Rental r WHERE r.carId = :carId AND r.startKilometer = :startKilometer")
    //public Rental findRentalByCarIdAndStartKilometer(Long carId,Double startKilometer);
}
