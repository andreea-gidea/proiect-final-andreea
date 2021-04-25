package com.siit.proiectfinalandreea.plantshop.controller;

import com.siit.proiectfinalandreea.plantshop.entity.CategoryEntity;

import com.siit.proiectfinalandreea.plantshop.model.CategoryDto;
import com.siit.proiectfinalandreea.plantshop.model.CategoryDtoCreateRequest;
import com.siit.proiectfinalandreea.plantshop.model.ClientDto;
import com.siit.proiectfinalandreea.plantshop.service.CategoryService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public List<CategoryDto> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/{categoryId}")
    public CategoryDto get(@PathVariable(name = "categoryId") Integer categoryId) {
        return categoryService.getCategory(categoryId);
    }
    @PostMapping()
    public CategoryDto createCategory(@RequestBody CategoryDtoCreateRequest categoryDto){
        return categoryService.createCategory(categoryDto);
    }

}
