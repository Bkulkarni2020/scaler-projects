package dev.basu.productservice.mappers;

import dev.basu.productservice.dtos.CategoryDto;
import dev.basu.productservice.models.Category;

import java.util.ArrayList;
import java.util.List;

public class  CategoryMapper {
    public static Category mapperToCategoryModel(CategoryDto categoryDto)
    {
        Category category =new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        category.setImageUrl(categoryDto.getImageUrl());
        return  category;
    }
    public static CategoryDto mapperToCategoryDto(Category category)
    {
        CategoryDto categoryDto =new CategoryDto();
        categoryDto.setId(category.getUuid());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        categoryDto.setImageUrl(category.getImageUrl());
        return  categoryDto;
    }
    public static List<CategoryDto> mapperToCategoryDto(List<Category> categories)
    {
        List<CategoryDto> categoryDtos =new ArrayList<>();
        categories.forEach( category -> {
            CategoryDto categoryDto =new CategoryDto();
            categoryDto.setId(category.getUuid());
            categoryDto.setName(category.getName());
            categoryDto.setDescription(category.getDescription());
            categoryDto.setImageUrl(category.getImageUrl());
            categoryDtos.add(categoryDto);
        });
        return  categoryDtos;
    }
}
