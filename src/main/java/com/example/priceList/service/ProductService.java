package com.example.priceList.service;

import com.example.priceList.dto.ProductDTO;
import com.example.priceList.exceptions.ResourceNotFoundException;
import com.example.priceList.model.Product;
import com.example.priceList.repository.JpaProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class ProductService {

    private final JpaProductRepository repository;

    public ProductService(JpaProductRepository repository) {
        this.repository = repository;
    }

    public ProductDTO findById(Long id) throws ResourceNotFoundException {
        log.debug("Find product by id {}", id);
        Optional<Product> product = repository.findById(id);

        if (product.isEmpty()) {
            throw new ResourceNotFoundException("Product not found - id" + id);
        }

        return new ProductDTO(product.get());
    }

    public ProductDTO save(ProductDTO productDTO) {
        log.debug("Persist product {}", productDTO);
        Product product = repository.save(productDTO.toDomainEntity());
        productDTO.setId(product.getId());
        return productDTO;
    }

    public Set<ProductDTO> findAll() {
        log.debug("Find all products");
        return repository.findAll().stream().map(ProductDTO::new).collect(Collectors.toSet());
    }
}
