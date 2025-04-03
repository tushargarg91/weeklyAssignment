package com.week2assignment.ProductCatalog.dto;

import com.week2assignment.ProductCatalog.entities.Category;
import com.week2assignment.ProductCatalog.entities.Product;

public class ProductConvertor {
    public static ProductDTO toDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getCategory().getId());
    }

    public static Product toEntity(ProductDTO dto, Category category) {
        return new Product(null, dto.getName(), dto.getPrice(), category);
    }
}

