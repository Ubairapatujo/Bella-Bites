package com.bakery.bakery_management.repository;

import com.bakery.bakery_management.model.payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface paymentrepository extends JpaRepository<payment, Integer> {
}
