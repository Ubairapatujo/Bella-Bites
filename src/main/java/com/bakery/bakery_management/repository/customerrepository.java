package com.bakery.bakery_management.repository;
import com.bakery.bakery_management.model.customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface customerrepository extends JpaRepository<customer, Integer> {
}
