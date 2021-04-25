package com.siit.proiectfinalandreea.service;

import com.siit.proiectfinalandreea.plantshop.entity.CategoryEntity;
import com.siit.proiectfinalandreea.plantshop.mapper.CategoryMapper;
import com.siit.proiectfinalandreea.plantshop.model.CategoryDto;
import com.siit.proiectfinalandreea.plantshop.repository.CategoryRepository;
import com.siit.proiectfinalandreea.plantshop.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

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
        List<CategoryEntity> categoryEntities = new ArrayList<>();
        when(categoryRepository.findAll()).thenReturn(categoryEntities);

        var allCategories = categoryService.getCategories();

        assertThat(allCategories).isNotNull();
        assertThat(allCategories.isEmpty()).isEqualTo(true);
    }

    @Test
    public void getAllCategoriesWithCategoryList(){
        List<CategoryEntity> categoryEntities = new ArrayList<>();
        var categoryEntity = new CategoryEntity(1,"COMMON GREEN PLANTS");

        categoryEntities.add(categoryEntity);
        categoryEntities.add(categoryEntity);

        var cat = new CategoryDto(1,"COMMON GREEN PLANTS");

        Mockito.when(categoryRepository.findAll()).thenReturn(categoryEntities);
        Mockito.when(categoryMapper.mapListEntityToListDto(ArgumentMatchers.any())).thenReturn(cat);

        var allCat = categoryService.getCategories();

        assertThat(allCat).isNotNull();
        assertThat(allCat.size()).isEqualTo(2);
        assertThat(allCat.get(0)).isNotNull();
        assertThat(allCat.get(0).getCategoryName()).isEqualTo(categoryEntity.getCategoryName());
    }
}