package com.example.priceList.repository;

import com.example.priceList.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<Product, Long> { }
