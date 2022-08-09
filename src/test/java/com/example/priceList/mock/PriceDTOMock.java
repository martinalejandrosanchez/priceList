package com.example.priceList.mock;

import com.example.priceList.dto.PriceDTO;
import com.example.priceList.model.Currency;
import com.example.priceList.util.Utils;

import java.math.BigDecimal;
import java.text.ParseException;

public class PriceDTOMock {
    public static PriceDTO create(
        Long priceId,
        Long brandId,
        String startDate,
        String endDate,
        Long priceList,
        Long productId,
        Integer priority,
        BigDecimal price,
        Currency curr
    ) throws ParseException {
        return PriceDTO.builder()
            .priceId(priceId)
            .price(price)
            .brandId(brandId)
            .productId(productId)
            .startDate(Utils.convertStringToDate(startDate))
            .endDate(Utils.convertStringToDate(endDate))
            .priceList(priceList)
            .priority(priority)
            .curr(curr)
            .build();
    }
}
