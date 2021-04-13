package com.siit.proiectfinalandreea.plantshop.service;

import com.siit.proiectfinalandreea.plantshop.entity.CategoryEntity;
import com.siit.proiectfinalandreea.plantshop.exception.CategoryNotFoundException;
import com.siit.proiectfinalandreea.plantshop.exception.ClientNotFoundException;
import com.siit.proiectfinalandreea.plantshop.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryEntity> getCategories() {
        return categoryRepository.findAll();
    }

    public CategoryEntity getCategory(Integer categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("No such id for a category  "+categoryId));
    }


}
