package dev.basu.productservice.mappers;

import dev.basu.productservice.dtos.CategoryDto;
import dev.basu.productservice.dtos.ProductDto;
import dev.basu.productservice.models.Category;
import dev.basu.productservice.models.Price;
import dev.basu.productservice.models.Product;

import java.util.List;

public class ProductMapper {
    public  static ProductDto mapperToProductDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getUuid());
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        Price price = product.getPrice();
        productDto.setPrice(price.getPrice());
        productDto.setCurrency(price.getCurrency());
        productDto.setImage(product.getImage());
        Category category = product.getCategory();
       //List<Product> productList  = category.getp();
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getUuid());
        categoryDto.setName(category.getName());
        productDto.setCategory(categoryDto);
        return productDto;
    }
    public  static  Product mapperToProduct(ProductDto productDto)
    {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        Price price = new Price();
        price.setPrice(productDto.getPrice());
        price.setCurrency(productDto.getCurrency());
        product.setPrice(price);
        product.setImage(productDto.getImage());
        CategoryDto categoryDto = productDto.getCategory();
        Category category = null;
       // if (categoryDto != null && categoryDto.getName() != null) {
//
       //     category = categoryRepository.findByName(categoryDto.getName());
        //}
        if (category == null) {
            category = new Category();
            category.setName(categoryDto.getName());
        }
        //category.getProducts().add(product);
        product.setCategory(category);

        product.setCategory(category);
        return product;

    }
}
