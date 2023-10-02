package dev.basu.productservice.repositories;

import dev.basu.productservice.models.Category;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

@Lazy
public interface CategoryRepository
        extends JpaRepository<Category, UUID> {
    @Override
    List<Category> findAllById(Iterable<UUID> uuids);
    Category findByName(String name);
}
