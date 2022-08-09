package com.example.priceList.service;

import com.example.priceList.dto.PriceCriteriaDTO;
import com.example.priceList.dto.PriceDTO;
import com.example.priceList.exceptions.ResourceNotFoundException;
import com.example.priceList.model.Brand;
import com.example.priceList.model.Price;
import com.example.priceList.repository.JpaPriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class PriceService {

    private final JpaPriceRepository repository;

    public PriceService(JpaPriceRepository jpaPriceRepository) {
        this.repository = jpaPriceRepository;
    }

    public PriceDTO findById(Long id) throws ResourceNotFoundException {
        log.debug("Find price by id {}", id);
        Optional<Price> price = repository.findById(id);

        if (price.isEmpty()) {
            throw new ResourceNotFoundException("Price not found - id: " + id);
        }

        return new PriceDTO(price.get());
    }

    public PriceDTO save(PriceDTO priceDTO) throws ResourceNotFoundException {
        log.debug("Persist price {}", priceDTO);
        try {
            Price price = repository.save(priceDTO.toDomainEntity());
            priceDTO.setPriceId(price.getPriceId());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("Brand not found - id " + priceDTO.getBrandId());
        }
        return priceDTO;
    }

    public List<PriceDTO> findAll() {
        log.debug("Find all prices");
        return repository.findAll().stream().map(PriceDTO::new).collect(Collectors.toList());
    }

    public PriceDTO getPriceByCriteria(PriceCriteriaDTO priceCriteriaDTO) throws ResourceNotFoundException {
        Price price = repository.getPriceByCriteria(
                new Brand(priceCriteriaDTO.getBrandId()),
                priceCriteriaDTO.getProductId(),
                priceCriteriaDTO.getDate()
        );

        if (price == null) {
            throw new ResourceNotFoundException("Price not found with params: " + priceCriteriaDTO);
        }

        return new PriceDTO(price);
    }
}
