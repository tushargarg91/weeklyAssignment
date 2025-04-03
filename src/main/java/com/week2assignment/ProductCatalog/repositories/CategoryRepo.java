package com.week2assignment.ProductCatalog.repositories;

import com.week2assignment.ProductCatalog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
