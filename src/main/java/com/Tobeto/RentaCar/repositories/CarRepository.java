package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.concretes.Brand;
import com.Tobeto.RentaCar.entities.concretes.Car;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandSearchListResponse;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    boolean existsByPlate(String name);
    //List<Car> findByBrandIdIn(List<GetBrandSearchListResponse> brand


    @Query("SELECT new com.Tobeto.RentaCar.service.dto.response.Car.GetCarListResponse(" +
            "c.kilometer, c.plate, year, c.dailyPrice ," +
            "c.gearType, c.fuelType, c.category, c.passengerCapacity ," +
            "new com.Tobeto.RentaCar.service.dto.response.Model.GetModelListResponse(c.model.name, c.model.brand.name), " +
            "new com.Tobeto.RentaCar.service.dto.response.Color.GetColorListResponse(c.color.name)) " +
            "FROM Car c " +
            "WHERE c.id NOT IN (" +
            "    SELECT DISTINCT r.car.id " +
            "    FROM Rental r " +
            "    WHERE r.startDate <= :endDate AND r.endDate >= :startDate)")

    List<GetCarListResponse> findAvailableCars(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
