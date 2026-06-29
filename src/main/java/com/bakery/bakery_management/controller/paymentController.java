package com.bakery.bakery_management.controller;

import com.bakery.bakery_management.model.payment;
import com.bakery.bakery_management.repository.paymentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/payments") // Browser mein: localhost:8080/payments
public class paymentController {

    @Autowired
    private paymentrepository paymentRepository;

    @GetMapping
    public List<payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @PostMapping
    public payment addPayment(@RequestBody payment pay) {
        return paymentRepository.save(pay);
    }
}
