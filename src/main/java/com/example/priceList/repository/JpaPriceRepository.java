package com.example.priceList.repository;

import com.example.priceList.model.Brand;
import com.example.priceList.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface JpaPriceRepository extends JpaRepository<Price, Long> {
    @Query(HQLQuery.GET_PRICE_BY_CRITERIA)
    Price getPriceByCriteria(@Param("brand") Brand brand, @Param("productId") Long productId, @Param("date") Date date);
}