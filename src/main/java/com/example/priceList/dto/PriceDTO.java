package com.example.priceList.dto;

import com.example.priceList.model.Brand;
import com.example.priceList.model.Currency;
import com.example.priceList.model.Price;
import com.example.priceList.util.Utils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class PriceDTO {

    @JsonProperty("price_id")
    private Long priceId;

    @JsonProperty("brand_id")
    private Long brandId;

    @JsonProperty("start_date")
    private Date startDate;

    @JsonProperty("end_date")
    private Date endDate;

    @JsonProperty("price_list")
    private Long priceList;

    @JsonProperty("product_id")
    private Long productId;

    private Integer priority;

    private BigDecimal price;

    @JsonProperty("currency")
    private Currency curr;

    public PriceDTO(Price price) {
        if (price != null) {
            this.priceId = price.getPriceId();
            this.brandId = price.getBrand().getId();
            this.startDate = price.getStartDate();
            this.endDate = price.getEndDate();
            this.priceList = price.getPriceList();
            this.productId = price.getProductId();
            this.priority = price.getPriority();
            this.price = price.getPrice();
            this.curr = price.getCurr();
        }
    }

    public Price toDomainEntity() {
        return new Price(
                this.priceId,
                new Brand(this.brandId),
                this.startDate,
                this.endDate,
                this.priceList,
                this.productId,
                this.priority,
                this.price,
                this.curr
        );
    }

    @Override
    public String toString() {
        return Utils.writeValueAsString(this);
    }
}
