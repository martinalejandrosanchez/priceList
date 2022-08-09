package com.example.priceList.controller;

import com.example.priceList.dto.PriceCriteriaDTO;
import com.example.priceList.dto.PriceDTO;
import com.example.priceList.mock.PriceCriteriaDTOMock;
import com.example.priceList.mock.PriceDTOMock;
import com.example.priceList.model.Currency;
import com.example.priceList.service.PriceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PriceService priceService;

    @Test
    void getPriceByCriteria_Case1() throws Exception {
        PriceCriteriaDTO priceCriteriaDTO = PriceCriteriaDTOMock.create("2020-06-14 10:00:00", 1L,35455L);

        PriceDTO priceDTOExpected = PriceDTOMock.create(
            1L,
            1L,
            "2020-06-14 00:00:00",
            "2020-12-31 23:59:59",
            1L,
            35455L,
            0,
            new BigDecimal("35.50"),
            Currency.EUR
        );

        mockMvc.perform(
                post("/prices/get-by-criteria")
                    .contentType("application/json")
                    .content(objectMapper.writeValueAsString(priceCriteriaDTO))
        ).andExpect(status().isOk())
        .andExpect(content().json(objectMapper.writeValueAsString(priceDTOExpected))).andReturn();
    }

    @Test
    void getPriceByCriteria_Case2() throws Exception {
        PriceCriteriaDTO priceCriteriaDTO = PriceCriteriaDTOMock.create("2020-06-14 16:00:00", 1L,35455L);

        PriceDTO priceDTOExpected = PriceDTOMock.create(
            2L,
            1L,
            "2020-06-14 15:00:00",
            "2020-06-14 18:30:00",
            2L,
            35455L,
            1,
            new BigDecimal("25.45"),
            Currency.EUR
        );

        mockMvc.perform(
                post("/prices/get-by-criteria")
                    .contentType("application/json")
                    .content(objectMapper.writeValueAsString(priceCriteriaDTO))
        ).andExpect(status().isOk())
        .andExpect(content().json(objectMapper.writeValueAsString(priceDTOExpected))).andReturn();
    }

    @Test
    void getPriceByCriteria_Case3() throws Exception {
        PriceCriteriaDTO priceCriteriaDTO = PriceCriteriaDTOMock.create("2020-06-14 21:00:00", 1L,35455L);

        PriceDTO priceDTOExpected = PriceDTOMock.create(
            1L,
            1L,
            "2020-06-14 00:00:00",
            "2020-12-31 23:59:59",
            1L,
            35455L,
            0,
            new BigDecimal("35.50"),
            Currency.EUR
        );

        mockMvc.perform(
                post("/prices/get-by-criteria")
                    .contentType("application/json")
                    .content(objectMapper.writeValueAsString(priceCriteriaDTO))
        ).andExpect(status().isOk())
        .andExpect(content().json(objectMapper.writeValueAsString(priceDTOExpected))).andReturn();
    }

    @Test
    void getPriceByCriteria_Case4() throws Exception {
        PriceCriteriaDTO priceCriteriaDTO = PriceCriteriaDTOMock.create("2020-06-15 10:00:00", 1L,35455L);

        PriceDTO priceDTOExpected = PriceDTOMock.create(
            3L,
            1L,
            "2020-06-15 00:00:00",
            "2020-06-15 11:00:00",
            3L,
            35455L,
            1,
            new BigDecimal("30.50"),
            Currency.EUR
        );

        mockMvc.perform(
                post("/prices/get-by-criteria")
                    .contentType("application/json")
                    .content(objectMapper.writeValueAsString(priceCriteriaDTO))
        ).andExpect(status().isOk())
        .andExpect(content().json(objectMapper.writeValueAsString(priceDTOExpected))).andReturn();
    }

    @Test
    void getPriceByCriteria_Case5() throws Exception {
        PriceCriteriaDTO priceCriteriaDTO = PriceCriteriaDTOMock.create("2020-06-16 21:00:00", 1L,35455L);

        PriceDTO priceDTOExpected = PriceDTOMock.create(
            4L,
            1L,
            "2020-06-15 16:00:00",
            "2020-12-31 23:59:59",
            4L,
            35455L,
            1,
            new BigDecimal("38.95"),
            Currency.EUR
        );

        mockMvc.perform(
                post("/prices/get-by-criteria")
                    .contentType("application/json")
                    .content(objectMapper.writeValueAsString(priceCriteriaDTO))
        ).andExpect(status().isOk())
        .andExpect(content().json(objectMapper.writeValueAsString(priceDTOExpected))).andReturn();
    }
}