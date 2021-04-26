package com.siit.proiectfinalandreea.plantshop.service;

import com.siit.proiectfinalandreea.plantshop.entity.CategoryEntity;
import com.siit.proiectfinalandreea.plantshop.mapper.CategoryMapper;
import com.siit.proiectfinalandreea.plantshop.model.CategoryDto;
import com.siit.proiectfinalandreea.plantshop.model.CategoryDtoCreateRequest;
import com.siit.proiectfinalandreea.plantshop.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private CategoryMapper categoryMapper;

    @Test
    public void getAllCategoriesWithEmptyList(){
        //Given
        List<CategoryEntity> categoryEntities = new ArrayList<>();
        when(categoryRepository.findAll()).thenReturn(categoryEntities);

        //When
        var allCategories = categoryService.getCategories();

        //Then
        assertThat(allCategories).isNotNull();
        assertThat(allCategories.isEmpty()).isEqualTo(true);
    }

    @Test
    public void getAllCategoriesWithCategoryList(){
        List<CategoryEntity> categoryEntities = new ArrayList<>();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        var categoryEntity = CategoryEntity.builder()
                .categoryName("COMMON GREEN PLANTS")
                .id(1)
                .build();

        categoryEntities.add(categoryEntity);
        categoryEntities.add(categoryEntity);

        var cat = CategoryDto.builder()
                .id(1)
                .categoryName("COMMON GREEN PLANTS")
                .build();
        categoryDtos.add(cat);
        categoryDtos.add(cat);

        Mockito.when(categoryRepository.findAll()).thenReturn(categoryEntities);
        Mockito.when(categoryMapper.mapListEntityToListDto(ArgumentMatchers.any())).thenReturn(categoryDtos);

        var allCat = categoryService.getCategories();

        assertThat(allCat).isNotNull();
        assertThat(allCat.size()).isEqualTo(2);
        assertThat(allCat.get(0)).isNotNull();
        assertThat(allCat.get(0).getCategoryName()).isEqualTo(categoryEntity.getCategoryName());
    }

    @Test
    public void getCategoryById(){

        var categoryEntity = CategoryEntity.builder()
                .categoryName("COMMON GREEN PLANTS")
                .id(1)
                .build();

        var cat = CategoryDto.builder()
                .id(1)
                .categoryName("COMMON GREEN PLANTS")
                .build();

        Mockito.when(categoryRepository.findById(1)).thenReturn(Optional.of(categoryEntity));
        Mockito.when(categoryMapper.mapEntityToDto(ArgumentMatchers.any())).thenReturn(cat);

        var category = categoryService.getCategory(1);

        assertThat(category).isNotNull();
        assertThat(category.getCategoryName()).isEqualTo(categoryEntity.getCategoryName());
    }

    @Test
    public void createCategory(){

        var categoryEntity = CategoryEntity.builder()
                .categoryName("COMMON GREEN PLANTS")
                .id(1)
                .build();

        var cat = new CategoryDtoCreateRequest();
        cat.setCategoryName("COMMON GREEN PLANTS");
        var categoryDto = CategoryDto.builder()
                .id(1)
                .categoryName("COMMON GREEN PLANTS")
                .build();

        Mockito.when(categoryMapper.mapDtoCreateRequestToEntity(ArgumentMatchers.any())).thenReturn(categoryEntity);
        Mockito.when(categoryRepository.save(ArgumentMatchers.any())).thenReturn(categoryEntity);
        Mockito.when(categoryMapper.mapEntityToDto(ArgumentMatchers.any())).thenReturn(categoryDto);

        var category = categoryService.createCategory(cat);

        assertThat(category).isNotNull();
        assertThat(category.getCategoryName()).isEqualTo(categoryEntity.getCategoryName());
    }
}