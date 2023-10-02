package dev.basu.productservice.repositories;

import dev.basu.productservice.models.Product;
import dev.basu.productservice.repositories.CustomQueries.ProductQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, UUID> {
    @Query(value = ProductQueries.FIND_PRODUCT_BY_ID)
    Optional<Product>findById(UUID uuid);

    @Query(value = ProductQueries.FIND_ALL_PRODUCT)
    List<Product> findAllProducts();
    @Query(value = ProductQueries.FIND_ALL_PRODUCT_BY_CATEGORY)
    List<Product> getAllProductByCategory(String categoryName);

    @Query(nativeQuery = true, value = ProductQueries.GET_ALL_PRODUCT_CATEGORY)
    List<String> getAllProductCategory();
}