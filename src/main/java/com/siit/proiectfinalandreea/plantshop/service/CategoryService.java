package com.siit.proiectfinalandreea.plantshop.service;

import com.siit.proiectfinalandreea.plantshop.domain.model.CategoryDto;
import com.siit.proiectfinalandreea.plantshop.mapper.CategoryEntityToCategoryDtoMapper;
import com.siit.proiectfinalandreea.plantshop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryEntityToCategoryDtoMapper categoryEntityToCategoryDtoMapper;
    private final CategoryRepository categoryRepository;


    @Transactional(readOnly = true)
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(catEnt -> categoryEntityToCategoryDtoMapper.mapEntityToDto(catEnt))
                .collect(toList());
    }

}
