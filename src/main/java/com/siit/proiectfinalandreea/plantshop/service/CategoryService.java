package com.siit.proiectfinalandreea.plantshop.service;

import com.siit.proiectfinalandreea.plantshop.entity.CategoryEntity;
import com.siit.proiectfinalandreea.plantshop.exception.CategoryNotFoundException;
import com.siit.proiectfinalandreea.plantshop.mapper.CategoryMapper;
import com.siit.proiectfinalandreea.plantshop.model.CategoryDto;
import com.siit.proiectfinalandreea.plantshop.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDto> getCategories() {
        return categoryMapper.mapListEntityToListDto(categoryRepository.findAll());
    }

    public CategoryDto getCategory(Integer categoryId) {
        return categoryMapper.mapEntityToDto(categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("No such id for a category  "+categoryId)));
    }


}
