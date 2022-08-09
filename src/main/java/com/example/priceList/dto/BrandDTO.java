package com.example.priceList.dto;

import com.example.priceList.model.Brand;
import com.example.priceList.util.Utils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BrandDTO {
    private Long id;

    @JsonProperty("brand_name")
    private String name;

    public BrandDTO(Brand brandDTO) {
        this.id = brandDTO.getId();
        this.name = brandDTO.getName();
    }

    public Brand toDomainEntity() {
        return new Brand(this.id, this.name);
    }

    @Override
    public String toString() {
        return Utils.writeValueAsString(this);
    }
}
