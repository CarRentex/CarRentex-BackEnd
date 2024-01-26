package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String username);
    boolean existsUserByEmail(String email);
}


