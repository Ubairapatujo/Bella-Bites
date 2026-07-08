package com.bakery.bakery_management.repository;

import com.bakery.bakery_management.model.orders;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ordersrepository extends JpaRepository<orders, Integer> {
    List<orders> findByEmployeeId(int employeeId);
    List<orders> findByEmployeeIdAndStatus(int employeeId, String status);
}