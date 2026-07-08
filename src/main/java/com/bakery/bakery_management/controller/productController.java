package com.bakery.bakery_management.controller;

import com.bakery.bakery_management.model.product;
import com.bakery.bakery_management.repository.productrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class productController {

    @Autowired
    private productrepository productRepository;

    @GetMapping
    public List<product> getAll() {
        return productRepository.findAll();
    }

    @PostMapping
    public product add(@RequestBody product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public product update(@PathVariable int id, @RequestBody product updated) {
        product existing = productRepository.findById(id).orElseThrow();
        existing.setProductName(updated.getProductName());
        existing.setPrice(updated.getPrice());
        existing.setStockQty(updated.getStockQty());
        return productRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        productRepository.deleteById(id);
        return "Deleted!";
    }
}