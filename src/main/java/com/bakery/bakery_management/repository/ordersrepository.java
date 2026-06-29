package com.bakery.bakery_management.repository;

import com.bakery.bakery_management.model.orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ordersrepository extends JpaRepository<orders, Integer> {
}
