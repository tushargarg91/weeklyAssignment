package com.week2assignment.ProductCatalog.controller;

import com.week2assignment.ProductCatalog.dto.ProductDTO;
import com.week2assignment.ProductCatalog.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProducts")
    public Page<ProductDTO> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size,
                                           @RequestParam(defaultValue = "id") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return productService.getAllProducts(pageable);
    }


    @PostMapping("/createProduct")
    public ProductDTO addProduct(@RequestBody ProductDTO dto) {
        return productService.addProduct(dto);
    }

}

