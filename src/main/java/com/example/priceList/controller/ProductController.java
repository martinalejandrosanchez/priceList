package com.example.priceList.controller;

import com.example.priceList.dto.ProductDTO;
import com.example.priceList.exceptions.ResourceNotFoundException;
import com.example.priceList.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return productService.findById(id);
    }

    @PostMapping
    public ProductDTO save(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @GetMapping
    public Set<ProductDTO> findAll() {
        return productService.findAll();
    }
}
