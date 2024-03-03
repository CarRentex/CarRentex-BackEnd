package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.concretes.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    @Query("SELECT MONTH(r.startDate), SUM(r.totalPrice) FROM Rental r WHERE YEAR(r.startDate) = :year GROUP BY MONTH(r.startDate)")
    List<Object[]> findYearlyIncome(@Param("year") int year);

}
