package dev.basu.productservice.services;

import dev.basu.productservice.dtos.FakeStoreProductDto;
import dev.basu.productservice.dtos.GenericProductDto;
import dev.basu.productservice.dtos.ProductDto;
import dev.basu.productservice.exceptions.NotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;
    private String specificProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String productRequestsBaseUrl = "https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private GenericProductDto convertFakeStoreProductIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto) {

        GenericProductDto product = new GenericProductDto();
       // product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());

        return product;
    }


    @Override
    public List<ProductDto> getAllProducts() {
        return null;
    }

    @Override
    public List<String> getAllCategories() {
        return null;
    }

    @Override
    public ProductDto getProductById(String id) throws NotFoundException {
        return null;
    }

    @Override
    public List<ProductDto> getProductsByCategory(String category) throws NotFoundException {
        return null;
    }

    @Override
    public ProductDto addonProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, String id) throws NotFoundException {
        return null;
    }

    @Override
    public ProductDto deleteProduct(String id) throws NotFoundException {
        return null;
    }

//    @Override
//    public GenericProductDto deleteProduct(UUID id) {
//        return null;
//    }
//
//    @Override
//    public GenericProductDto updateProduct(GenericProductDto product, UUID id) throws NotFoundException {
//        return null;
//    }

//    @Override
//    public GenericProductDto deleteProduct(Long id) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
//        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
//                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
//        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE,
//                requestCallback, responseExtractor, id);
//
//        FakeStoreProductDto fakeStoreProductDto = response.getBody();
//
//        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);
//    }
//
//    @Override
//    public GenericProductDto updateProduct(GenericProductDto product, Long id) throws NotFoundException {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> response =
//                restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class, id);
//        FakeStoreProductDto fakeStoreProductDto = response.getBody();
//            if (fakeStoreProductDto == null) {
//            throw new NotFoundException("Product with id: " + id + " doesn't exist.");
//        }
//        RequestCallback requestCallback = restTemplate.httpEntityCallback(product,FakeStoreProductDto.class);
//        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
//                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
//        ResponseEntity<FakeStoreProductDto> responseUpdate = restTemplate.execute(specificProductRequestUrl, HttpMethod.PUT,
//                requestCallback, responseExtractor, id);
//        FakeStoreProductDto fakeStoreProductDtoResult = response.getBody();
//
//        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDtoResult);
//    }

}
