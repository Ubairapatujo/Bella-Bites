package com.bakery.bakery_management.repository;

import com.bakery.bakery_management.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository ko batana parta hai kis model ke liye hai (employee) aur uski ID ka type kya hai (Integer)
public interface employeerepository extends JpaRepository<employee, Integer> {
}

