package com.bakery.bakery_management.controller;

import com.bakery.bakery_management.model.employee;
import com.bakery.bakery_management.repository.employeerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class employeeController {

    @Autowired
    private employeerepository employeeRepository;

    @GetMapping
    public List<employee> getAll() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public employee add(@RequestBody employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public employee update(@PathVariable int id, @RequestBody employee updated) {
        employee existing = employeeRepository.findById(id).orElseThrow();
        existing.setEmployeeName(updated.getEmployeeName());
        existing.setRole(updated.getRole());
        existing.setSalary(updated.getSalary());
        return employeeRepository.save(existing);
    }

 @DeleteMapping("/{id}")
public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
    try {
        employeeRepository.deleteById(id);
        return ResponseEntity.ok("Deleted!");
    } catch (Exception e) {
        return ResponseEntity.badRequest()
                .body(Map.of("error", "Cannot delete: this employee has assigned orders."));
    }
}
}