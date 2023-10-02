package dev.basu.productservice.controllers;

import dev.basu.productservice.dtos.GenericProductDto;
import dev.basu.productservice.dtos.ProductDto;
import dev.basu.productservice.exceptions.NotFoundException;
import dev.basu.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<ProductDto> getAllProducts()
    {
        return productService.getAllProducts();
    }
    @GetMapping("{id}")
    public ProductDto getProductById(@PathVariable("id") UUID id) throws NotFoundException {
        return productService.getProductById(String.valueOf(id));
    }
    @DeleteMapping("{id}")
    public ProductDto deleteProductById(@PathVariable("id") UUID id) throws NotFoundException {
        return productService.deleteProduct(String.valueOf(id));
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductDto product) {
        return new ResponseEntity<>(productService.addonProduct(product),HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public  ProductDto updateProductById(@PathVariable("id") UUID id,@RequestBody ProductDto product) throws NotFoundException {
        return  productService.updateProduct(product, String.valueOf(id));
    }
}
