package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.concretes.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Integer> {

    List<District> findAllByCityId(int cityId);
}
