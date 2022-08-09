package com.example.priceList.repository;

public class HQLQuery {
    public static final String GET_PRICE_BY_CRITERIA = """
        SELECT p
        FROM Price p
        WHERE p.brand = :brand
        AND p.productId = :productId
        AND p.startDate <= :date
        AND p.endDate >= :date
        AND p.priority = (
            SELECT MAX(pp.priority) AS priority
            FROM Price pp
            WHERE pp.brand = p.brand
            AND pp.startDate <= :date
            AND pp.endDate >= :date
        )
    """;
}