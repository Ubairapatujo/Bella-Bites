package com.bakery.bakery_management.controller;

import com.bakery.bakery_management.model.category;
import com.bakery.bakery_management.repository.categoryrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class categoryController {

    @Autowired
    private categoryrepository categoryRepository;

    // GET — saari categories dekho
    @GetMapping
    public List<category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // POST — nayi category add karo
    @PostMapping
    public category addCategory(@RequestBody category category) {
        return categoryRepository.save(category);
    }

    // DELETE — category delete karo
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryRepository.deleteById(id);
        return "Category deleted!";
    }
}
