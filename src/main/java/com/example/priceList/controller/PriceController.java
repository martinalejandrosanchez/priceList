package com.example.priceList.controller;

import com.example.priceList.dto.PriceCriteriaDTO;
import com.example.priceList.dto.PriceDTO;
import com.example.priceList.exceptions.ResourceNotFoundException;
import com.example.priceList.service.PriceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/{id}")
    public PriceDTO findById(@PathVariable("id") Long priceId) throws ResourceNotFoundException {
        return priceService.findById(priceId);
    }

    @PostMapping
    public PriceDTO save(@RequestBody PriceDTO priceDTO) throws ResourceNotFoundException {
        return priceService.save(priceDTO);
    }

    @GetMapping
    public List<PriceDTO> findAll() {
        return priceService.findAll();
    }

    @PostMapping("/get-by-criteria")
    public PriceDTO getPriceByCriteria(@RequestBody PriceCriteriaDTO priceCriteriaDTO) throws ResourceNotFoundException {
        return priceService.getPriceByCriteria(priceCriteriaDTO);
    }
}
