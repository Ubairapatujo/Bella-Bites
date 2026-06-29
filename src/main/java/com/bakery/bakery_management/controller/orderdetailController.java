package com.bakery.bakery_management.controller;

import com.bakery.bakery_management.model.OrderDetail;
import com.bakery.bakery_management.repository.orderdetailrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/order-details")
public class orderdetailController {

    @Autowired
    private orderdetailrepository orderDetailRepository;

    @GetMapping
    public List<OrderDetail> getAllDetails() {
        return orderDetailRepository.findAll();
    }

    @PostMapping
    public OrderDetail addDetail(@RequestBody OrderDetail detail) {
        return orderDetailRepository.save(detail);
    }
}
