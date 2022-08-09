package com.example.priceList.dto;

import com.example.priceList.util.Utils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PriceCriteriaDTO {
    @JsonProperty("date")
    private Date date;

    @JsonProperty("brand_id")
    private Long brandId;

    @JsonProperty("product_id")
    private Long productId;

    @Override
    public String toString() {
        return Utils.writeValueAsString(this);
    }
}
