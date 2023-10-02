package dev.basu.productservice.services;

import dev.basu.productservice.dtos.GenericProductDto;
import dev.basu.productservice.dtos.ProductDto;
import dev.basu.productservice.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    //getAllProducts
    List<ProductDto>getAllProducts();
    //getAllCategories
    List<String> getAllCategories();
    //getProductById
    ProductDto getProductById(String id) throws NotFoundException;
    //getProductByCategory
    List<ProductDto> getProductsByCategory(String category) throws NotFoundException;
    //addonProduct
    ProductDto addonProduct(ProductDto productDto);
    //updateProduct
    ProductDto updateProduct(ProductDto productDto , String id) throws NotFoundException;
    //deleteProduct
    ProductDto deleteProduct(String id) throws NotFoundException;
}
