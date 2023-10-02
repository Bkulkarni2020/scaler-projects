package dev.basu.productservice.services.serviceimplements;

import dev.basu.productservice.dtos.CategoryDto;
import dev.basu.productservice.exceptions.NotFoundException;
import dev.basu.productservice.mappers.CategoryMapper;
import dev.basu.productservice.models.Category;
import dev.basu.productservice.repositories.CategoryRepository;
import dev.basu.productservice.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository)
    {
        this.categoryRepository=categoryRepository;
    }
    @Override
    public CategoryDto createCategory(CategoryDto category) {
        Category saveCategory= CategoryMapper.mapperToCategoryModel(category);
        Category result= categoryRepository.save(saveCategory);
        CategoryDto resultDto=CategoryMapper.mapperToCategoryDto(result);
        return resultDto;
    }

    @Override
    public CategoryDto getCategoryById(UUID id) throws NotFoundException {
       Optional<Category> result = categoryRepository.findById(id);
        CategoryDto resultDto=CategoryMapper.mapperToCategoryDto(result.get());
        return resultDto;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> result =   categoryRepository.findAll();
        List<CategoryDto> resultDto=CategoryMapper.mapperToCategoryDto(result);
        return resultDto;
    }

    @Override
    public CategoryDto deleteCategory(UUID id) {
        Optional<Category> result = categoryRepository.findById(id);
        if(result.get()!=null) {
            categoryRepository.deleteById(id);
        }
        CategoryDto resultDto=CategoryMapper.mapperToCategoryDto(result.get());
        return resultDto;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto category, UUID id) throws NotFoundException {
        Optional<Category> result = categoryRepository.findById(id);
        CategoryDto resultDto=null;
        if(result.get()!=null) {
            Category saveCategory= CategoryMapper.mapperToCategoryModel(category);
            Category saveCategoryResult= categoryRepository.save(saveCategory);
            resultDto=CategoryMapper.mapperToCategoryDto(saveCategoryResult);
        }
        return resultDto;
    }
}
