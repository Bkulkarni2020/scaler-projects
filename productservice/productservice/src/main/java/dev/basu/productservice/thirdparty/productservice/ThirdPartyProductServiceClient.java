package dev.basu.productservice.thirdparty.productservice;

import dev.basu.productservice.dtos.GenericProductDto;
import dev.basu.productservice.exceptions.NotFoundException;

import java.util.List;

public interface ThirdPartyProductServiceClient {
    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id) throws NotFoundException;

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProduct(Long id);

    GenericProductDto updateProduct(GenericProductDto product,Long id) throws NotFoundException;
}
