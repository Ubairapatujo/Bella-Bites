package com.bakery.bakery_management.controller;

import com.bakery.bakery_management.model.employee;
import com.bakery.bakery_management.repository.employeerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees") // Browser mein localhost:8080/employees se chalega
public class employeeController {

    @Autowired
    private employeerepository employeeRepository;

    // 1. Saare Employees dekhne ke liye (GET)
    @GetMapping
    public List<employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // 2. Naya Employee add karne ke liye (POST)
    @PostMapping
    public employee addEmployee(@RequestBody employee emp) {
        return employeeRepository.save(emp);
    }

    // 3. Employee delete karne ke liye by ID (DELETE)
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeRepository.deleteById(id);
        return "Employee deleted successfully!";
    }
}

