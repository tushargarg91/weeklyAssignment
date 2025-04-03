package com.week2assignment.ProductCatalog.controller;

import com.week2assignment.ProductCatalog.entities.Category;
import com.week2assignment.ProductCatalog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAllCategories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/createCategory")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }
}

