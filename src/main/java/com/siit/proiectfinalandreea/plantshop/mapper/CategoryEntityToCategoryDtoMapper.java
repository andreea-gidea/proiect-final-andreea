package com.siit.proiectfinalandreea.plantshop.mapper;

import com.siit.proiectfinalandreea.plantshop.domain.entity.CategoryEntity;
import com.siit.proiectfinalandreea.plantshop.domain.model.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryEntityToCategoryDtoMapper {
    public CategoryDto mapEntityToDto(CategoryEntity entity) {
        if (entity == null){
            return null;
        }
        return CategoryDto.builder()
                .id(entity.getId())
                .categoryName(entity.getCategoryName())
                .build();

    }

}
