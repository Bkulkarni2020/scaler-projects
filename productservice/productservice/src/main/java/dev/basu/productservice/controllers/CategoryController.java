package dev.basu.productservice.controllers;
import dev.basu.productservice.dtos.CategoryDto;
import dev.basu.productservice.exceptions.NotFoundException;
import dev.basu.productservice.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService)
    {
        this.categoryService = categoryService;
    }
    @GetMapping
    public List<CategoryDto> getAllCategory()
    {
        return categoryService.getAllCategories();
    }

    @GetMapping("{id}")
    public CategoryDto getCategoryById(@PathVariable("id") UUID id) throws NotFoundException {
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CategoryDto> deleteProductById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(
                categoryService.deleteCategory(id),
                HttpStatus.OK
        );
    }

    @PostMapping
    public CategoryDto createProduct(@RequestBody CategoryDto category)
    {
        return categoryService.createCategory(category);
    }

    @PutMapping("{id}")
    public CategoryDto updateProductById(@RequestBody CategoryDto category, @PathVariable("id") UUID id) throws NotFoundException
    {
        return categoryService.updateCategory(category,id);
    }
}
