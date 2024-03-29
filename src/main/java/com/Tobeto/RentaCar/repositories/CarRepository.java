package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.concretes.Brand;
import com.Tobeto.RentaCar.entities.concretes.Car;
import com.Tobeto.RentaCar.entities.concretes.Category;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandSearchListResponse;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCarListResponse;
import com.Tobeto.RentaCar.service.dto.response.Car.GetCategoryListResponse;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    boolean existsByPlate(String name);
    //List<Car> findByBrandIdIn(List<GetBrandSearchListResponse> brand
    @Query("SELECT new com.Tobeto.RentaCar.service.dto.response.Car.GetCategoryListResponse(" +
            "c.id, c.kilometer, c.year, c.dailyPrice, c.minFindeksRate, c.plate, " +
            "c.gearType, c.fuelType, c.category, c.passengerCapacity, c.imagePath," +
            "new com.Tobeto.RentaCar.service.dto.response.Model.GetModelListResponse(c.model.id, c.model.name, " +
            "new com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandListResponse(c.model.brand.id, c.model.brand.name))," +
            "new  com.Tobeto.RentaCar.service.dto.response.Color.GetColorResponse(c.color.name)" +
            ") " +
            "FROM Car c  WHERE c.category = :category")
    List<GetCategoryListResponse> findByCategory(@Param("category") Category category);


    @Query("SELECT new com.Tobeto.RentaCar.service.dto.response.Car.GetCarListResponse(" +
            "c.id, c.kilometer, c.year, c.dailyPrice, c.minFindeksRate, c.plate, " +
            "c.gearType, c.fuelType, c.category, c.passengerCapacity, c.imagePath," +
            "new com.Tobeto.RentaCar.service.dto.response.Model.GetModelListResponse(c.model.id, c.model.name, " +
            "new com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandListResponse(c.model.brand.id, c.model.brand.name))," +
            "new  com.Tobeto.RentaCar.service.dto.response.Color.GetColorResponse(c.color.name)" +
            ") " +
            "FROM Car c " +
            "WHERE c.id NOT IN (" +
            "    SELECT DISTINCT r.car.id " +
            "    FROM Rental r " +
            "    WHERE r.startDate <= :endDate AND r.endDate >= :startDate)")
    List<GetCarListResponse> findAvailableCars(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT new com.Tobeto.RentaCar.service.dto.response.Car.GetCarListResponse(" +
            "c.id, c.kilometer, c.year, c.dailyPrice, c.minFindeksRate, c.plate, c.gearType, c.fuelType, " +
            "c.category, c.passengerCapacity, c.imagePath, " +
            "new com.Tobeto.RentaCar.service.dto.response.Model.GetModelListResponse(c.model.id, c.model.name, " +
            "new com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandListResponse(c.model.brand.id, c.model.brand.name)), " +
            "new com.Tobeto.RentaCar.service.dto.response.Color.GetColorResponse(c.color.name))" +
            "FROM Car c " +
            "WHERE " +
            "(:minPrice IS NULL OR c.dailyPrice >= :minPrice) AND " +
            "(:maxPrice IS NULL OR c.dailyPrice <= :maxPrice) AND " +
            "(:modelId IS NULL OR c.model.id = :modelId OR :modelId IS NULL) AND " +
            "(:brandId IS NULL OR c.model.brand.id = :brandId OR :brandId IS NULL)")
    List<GetCarListResponse> findCarsByFilter(
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice,
            @Param("brandId") Integer brandId,
            @Param("modelId") Integer modelId);










}
