package com.example.week8_day3.repository;


import com.example.week8_day3.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByPriceGreaterThan(BigDecimal priceIsGreaterThan);

    List<Product> findByCategory(String category, Sort sort);

    long countByCategory(java.lang.String category);


}
