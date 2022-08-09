package com.example.priceList.controller;

import com.example.priceList.dto.BrandDTO;
import com.example.priceList.exceptions.ResourceNotFoundException;
import com.example.priceList.service.BrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/{id}")
    public BrandDTO findById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return brandService.findById(id);
    }

    @PostMapping
    public BrandDTO save(@RequestBody BrandDTO brandDTO) {
        return brandService.save(brandDTO);
    }

    @GetMapping
    public Set<BrandDTO> findAll() {
        return brandService.findAll();
    }
}
