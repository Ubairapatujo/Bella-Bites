package com.bakery.bakery_management.repository;

import com.bakery.bakery_management.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface orderitemrepository extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findByOrderId(Integer orderId);
}