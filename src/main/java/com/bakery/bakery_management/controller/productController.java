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
private productrepository productrepository;


    // GET — saare products dekho
    // Browser mein: localhost:8080/products

    @GetMapping
    public List<product> getAllProducts() {
        return productrepository.findAll();
    }


    // POST — naya product add karo
    @PostMapping
    public product addProduct(@RequestBody product product) {
        return productrepository.save(product);
    }

    // DELETE — product delete karo by ID
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        productrepository.deleteById(id);
        return "Product deleted!";
    }
}