package dev.basu.productservice.services;

import dev.basu.productservice.dtos.CategoryDto;
import dev.basu.productservice.dtos.GenericProductDto;
import dev.basu.productservice.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto category);

    CategoryDto getCategoryById(UUID id) throws NotFoundException;

    List<CategoryDto> getAllCategories();

    CategoryDto deleteCategory(UUID id);

    CategoryDto updateCategory(CategoryDto category,UUID id) throws NotFoundException;
}
