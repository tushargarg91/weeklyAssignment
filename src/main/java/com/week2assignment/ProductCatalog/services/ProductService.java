package com.week2assignment.ProductCatalog.services;

import com.week2assignment.ProductCatalog.dto.ProductConvertor;
import com.week2assignment.ProductCatalog.dto.ProductDTO;
import com.week2assignment.ProductCatalog.entities.Category;
import com.week2assignment.ProductCatalog.entities.Product;
import com.week2assignment.ProductCatalog.repositories.CategoryRepo;
import com.week2assignment.ProductCatalog.repositories.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;


@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepository;

    @Autowired
    private CategoryRepo categoryRepository;

    public Page<ProductDTO> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable).map(ProductConvertor::toDTO);
    }

    public ProductDTO addProduct(ProductDTO dto) {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Product product = productRepository.save(ProductConvertor.toEntity(dto, category));
        return ProductConvertor.toDTO(product);
    }
}

