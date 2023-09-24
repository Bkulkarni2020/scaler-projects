package dev.basu.productservice.services;

import dev.basu.productservice.dtos.GenericProductDto;
import dev.basu.productservice.exceptions.NotFoundException;
import dev.basu.productservice.models.Category;
import dev.basu.productservice.models.Price;
import dev.basu.productservice.models.Product;
import dev.basu.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{

    private ProductRepository  productRepository;
    public SelfProductServiceImpl(ProductRepository productRepository)
    {
        this.productRepository =productRepository;
    }
    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        Product productEntity=new Product();
        productEntity.setTitle(product.getTitle());
        productEntity.setImage(product.getImage());
        productEntity.setDescription(product.getDescription());
        Price priceEntity =new Price();
        priceEntity.setPrice(product.getPrice());
        priceEntity.setCurrency("Rupee");
        productEntity.setPrice(priceEntity);
        Category categoryEntity =new Category();
        categoryEntity.setName(product.getCategory());
        productEntity.setCategory(categoryEntity);
         productRepository.save(productEntity);
         return  product;

    }

    @Override
    public GenericProductDto getProductById(UUID id) throws NotFoundException {
        Optional<Product> productResult= productRepository.findById(id);
        GenericProductDto result=new GenericProductDto();
        result.setId(UUID.fromString(id.toString()));
        result.setCategory(productResult.get().getCategory().getName());
        result.setTitle(productResult.get().getTitle());
        result.setPrice(productResult.get().getPrice().getPrice());
        result.setImage(productResult.get().getImage());
        result.setDescription(productResult.get().getDescription());
        return  result;

    }

    @Override
    public List<GenericProductDto> getAllProducts() {
       List<Product> resultProducts= productRepository.findAll();
        List<GenericProductDto> resultList=new ArrayList<GenericProductDto>() ;

        for (Product productResult:resultProducts) {
            GenericProductDto result=new GenericProductDto();
            //result.setId(UUID.fromString(id.toString()));
            result.setCategory(productResult.getCategory().getName());
            result.setTitle(productResult.getTitle());
            result.setPrice(productResult.getPrice().getPrice());
            result.setImage(productResult.getImage());
            result.setDescription(productResult.getDescription());
            resultList.add(result);
        }
        return  resultList;
    }

    @Override
    public GenericProductDto deleteProduct(UUID id) {
        productRepository.deleteById(UUID.fromString(id.toString()));
        return new GenericProductDto();
    }

    @Override
    public GenericProductDto updateProduct(GenericProductDto product, UUID id) throws NotFoundException {
        return null;
    }


}
