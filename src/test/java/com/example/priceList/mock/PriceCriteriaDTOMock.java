package com.example.priceList.mock;

import com.example.priceList.dto.PriceCriteriaDTO;
import com.example.priceList.util.Utils;

import java.text.ParseException;

public class PriceCriteriaDTOMock {
    public static PriceCriteriaDTO create(String date, Long brandId, Long productId) throws ParseException {
        return PriceCriteriaDTO.builder().brandId(brandId).productId(productId).date(Utils.convertStringToDate(date)).build();
    }
}
