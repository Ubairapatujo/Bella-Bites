package com.bakery.bakery_management.controller;

import com.bakery.bakery_management.model.customer;
import com.bakery.bakery_management.repository.customerrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class customerController {

    @Autowired
    private customerrepository customerRepository;

    @GetMapping
    public List<customer> getAll() {
        return customerRepository.findAll();
    }

    @PostMapping
    public customer add(@RequestBody customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/{id}")
    public customer update(@PathVariable int id, @RequestBody customer updated) {
        customer existing = customerRepository.findById(id).orElseThrow();
        existing.setFullName(updated.getFullName());
        existing.setPhone(updated.getPhone());
        return customerRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        customerRepository.deleteById(id);
        return "Deleted!";
    }
}