package dev.basu.productservice.repositories;

import dev.basu.productservice.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository
        extends JpaRepository<Price, Long> {
}
