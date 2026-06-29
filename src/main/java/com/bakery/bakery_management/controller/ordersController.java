package com.bakery.bakery_management.controller;

import com.bakery.bakery_management.model.orders;
import com.bakery.bakery_management.repository.ordersrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders") // Browser mein: localhost:8080/orders
public class ordersController {

    @Autowired
    private ordersrepository ordersRepository;

    // Saare orders dekhne ke liye (GET)
    @GetMapping
    public List<orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    // Naya order add karne ke liye (POST)
    @PostMapping
    public orders addOrder(@RequestBody orders order) {
        return ordersRepository.save(order);
    }
}
