package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Integer> {
    boolean existsByName (String name);

    @Query("SELECT b.models FROM Brand b WHERE b.id = :brandId")
    List<Model> findModelsByBrandId(@Param("brandId") int brandId);
}
