package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.concretes.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageDataRepository extends JpaRepository<ImageData, Integer> {

    Optional<ImageData> findByName(String fileName);
}
