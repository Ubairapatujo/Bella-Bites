package com.bakery.bakery_management.repository;

import com.bakery.bakery_management.model.category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoryrepository extends JpaRepository<category, Integer> {

}
