package com.siit.proiectfinalandreea.plantshop.mapper;

import com.siit.proiectfinalandreea.plantshop.domain.entity.CategoryEntity;
import com.siit.proiectfinalandreea.plantshop.domain.entity.PlantEntity;
import com.siit.proiectfinalandreea.plantshop.domain.exception.CategoryNotFoundException;
import com.siit.proiectfinalandreea.plantshop.domain.model.CategoryDto;
import com.siit.proiectfinalandreea.plantshop.domain.model.PlantsDto;
import com.siit.proiectfinalandreea.plantshop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlantEntityToPlantDtoMapper {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityToCategoryDtoMapper categoryEntityToCategoryDtoMapper;

    public PlantsDto mapEntityToDto(PlantEntity entity) {
        if (entity == null) {
            return null;
        }
        return PlantsDto.builder()
                .id(entity.getId())
                .plantName(entity.getPlantName())
                .potDimension(entity.getPotDimension())
                .category(categoryEntityToCategoryDtoMapper.mapEntityToDto(entity.getCategoryEntity()))
                .price(entity.getPrice())
                .build();

    }
}
