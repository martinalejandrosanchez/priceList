package com.example.priceList.dto;

import com.example.priceList.model.Product;
import com.example.priceList.util.Utils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProductDTO {
    private Long id;

    @JsonProperty("product_name")
    private String name;

    public ProductDTO(Product product) {
        if (product != null) {
            this.id = product.getId();
            this.name = product.getName();
        }
    }

    public Product toDomainEntity() {
        return new Product(this.id, this.name);
    }

    @Override
    public String toString() {
        return Utils.writeValueAsString(this);
    }
}
