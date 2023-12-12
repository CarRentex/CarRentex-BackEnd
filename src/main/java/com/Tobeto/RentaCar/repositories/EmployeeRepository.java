package com.Tobeto.RentaCar.repositories;

import com.Tobeto.RentaCar.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
