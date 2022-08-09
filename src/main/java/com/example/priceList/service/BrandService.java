package com.example.priceList.service;

import com.example.priceList.dto.BrandDTO;
import com.example.priceList.exceptions.ResourceNotFoundException;
import com.example.priceList.model.Brand;
import com.example.priceList.repository.JpaBrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class BrandService {

    private final JpaBrandRepository repository;

    public BrandService(JpaBrandRepository repository) {
        this.repository = repository;
    }

    public BrandDTO findById(Long id) throws ResourceNotFoundException {
        log.debug("Find brand by id {}", id);
        Optional<Brand> brand = repository.findById(id);

        if (brand.isEmpty()) {
            throw new ResourceNotFoundException("Brand not found - id: " + id);
        }

        return new BrandDTO(brand.get());
    }

    public BrandDTO save(BrandDTO brandDTO) {
        log.debug("Persist brand {}", brandDTO);
        Brand brand = repository.save(brandDTO.toDomainEntity());
        brandDTO.setId(brand.getId());
        return brandDTO;
    }

    public Set<BrandDTO> findAll() {
        log.debug("Find all brands");
        return repository.findAll().stream().map(BrandDTO::new).collect(Collectors.toSet());
    }
}
