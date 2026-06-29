package com.bakery.bakery_management.repository;

import com.bakery.bakery_management.model.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productrepository extends JpaRepository<product, Integer> {

}