package dev.basu.productservice.services;

import dev.basu.productservice.dtos.GenericProductDto;
import dev.basu.productservice.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(UUID id) throws NotFoundException;

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProduct(UUID id);

    GenericProductDto updateProduct(GenericProductDto product,UUID id) throws NotFoundException;
}
