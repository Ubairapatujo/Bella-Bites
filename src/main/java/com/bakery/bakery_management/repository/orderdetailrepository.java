package com.bakery.bakery_management.repository;

import com.bakery.bakery_management.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderdetailrepository extends JpaRepository<OrderDetail, Integer> {
}
