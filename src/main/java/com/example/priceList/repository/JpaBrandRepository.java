package com.example.priceList.repository;

import com.example.priceList.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBrandRepository extends JpaRepository<Brand, Long> { }