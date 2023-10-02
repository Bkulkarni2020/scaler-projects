package dev.basu.productservice.services;

import dev.basu.productservice.dtos.CategoryDto;
import dev.basu.productservice.exceptions.NotFoundException;
import dev.basu.productservice.mappers.CategoryMapper;
import dev.basu.productservice.models.Category;
import dev.basu.productservice.repositories.CategoryRepository;
import dev.basu.productservice.services.serviceimplements.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CategoryServiceTests {
    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryServiceImpl categoryService;
    @InjectMocks
    private CategoryMapper categoryMapper;
    private CategoryDto categoryRequest;
    private Category category;
    private Category savedCategory;

    @BeforeEach
    public void setup()
    {
        categoryMapper=new CategoryMapper();
        category = Category.builder()
                .name("Test Category")
                .description("Test Category Description")
                .build();

        savedCategory = Category.builder()
                .name("New Test Category")
                .description("New Test Category Description")
                .uuid(UUID.fromString("6e6c83b8-97bf-4a06-9e55-544702900f7a"))
                .build();

        categoryRequest = categoryRequest.builder()
                .name("New Test Category ")
                .description("New Test Category Description")
                .build();
    }

    @DisplayName("JUnit test for getAllCategory method")
    @Test
    public void testGetAllCategory_thenReturnCategoryList(){
        // given - precondition or setup
        Category category1 = Category.builder()
                .name("Test Category 1")
                .description("Test Category Description 1")
                .build();

        given(categoryRepository.findAll()).willReturn(List.of(category,category1));

        // when -  action or the behaviour that we are going test
        List<CategoryDto> categoryList = categoryService.getAllCategories();

        // then - verify the output
        assertThat(categoryList).isNotNull();
        assertThat(categoryList.size()).isEqualTo(2);
    }

    // JUnit test for getAllCategory's method
    @DisplayName("JUnit test for getAllCategory method (negative scenario) return empty list")
    @Test
    public void testGetAllCategory_thenReturnEmptyCategoryList(){
        // given - precondition or setup
        Category category1 = Category.builder()
                .name("Test Category 1")
                .description("Test Category Description 1")
                .build();

        given(categoryRepository.findAll()).willReturn(Collections.emptyList());

        // when -  action or the behaviour that we are going test
        List<CategoryDto> categoryResult = categoryService.getAllCategories();

        // then - verify the output
        assertThat(categoryResult).isEmpty();
        assertThat(categoryResult.size()).isEqualTo(0);
    }

    // JUnit test for getCategoryById method
    @DisplayName("JUnit test for getCategoryById method")
    @Test
    public void testGetCategoryById_thenReturnCategoryObject() throws NotFoundException {
        // given
        given(categoryRepository.findById(UUID.fromString("6e6c83b8-97bf-4a06-9e55-544702900f7a"))).willReturn(Optional.of(category));

        // when
        CategoryDto categoryResult = categoryService.getCategoryById(UUID.fromString("6e6c83b8-97bf-4a06-9e55-544702900f7a"));

        // then
        assertThat(categoryResult).isNotNull();
    }

    // JUnit test for saveEmployee method
    @DisplayName("JUnit test for saveCategory method")
    @Test
    public void testSaveCategory_thenReturnCategoryObject(){
        // when -  action or the behaviour that we are going test
        when(categoryRepository.save(any())).thenReturn(savedCategory);
        CategoryDto savedCategoryResult = categoryService.createCategory(categoryRequest);

        // then - verify the output
        assertThat(savedCategoryResult).isNotNull();
        verify(categoryRepository,times(1)).save(any());
    }

    // JUnit test for saveEmployee method
    @DisplayName("JUnit test for saveCategory method")
    @Test
    public void testUpdateCategory_thenReturnCategoryObject() throws NotFoundException {
        // when -  action or the behaviour that we are going test
        when(categoryRepository.save(any())).thenReturn(savedCategory);
        CategoryDto updatedCategoryResult = categoryService.updateCategory(categoryRequest,UUID.fromString("6e6c83b8-97bf-4a06-9e55-544702900f7a"));

        // then - verify the output
        assertThat(updatedCategoryResult).isNotNull();
        verify(categoryRepository,times(1)).save(any());
    }

}
