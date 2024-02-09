package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.concretes.Brand;
import com.Tobeto.RentaCar.entities.concretes.Car;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandSearchListResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    boolean existsByPlate(String name);
    //List<Car> findByBrandIdIn(List<GetBrandSearchListResponse> brandIds);
}
