package com.bakery.bakery_management.repository;

import com.bakery.bakery_management.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface employeerepository extends JpaRepository<employee, Integer> {
    Optional<employee> findByUsername(String username);
}