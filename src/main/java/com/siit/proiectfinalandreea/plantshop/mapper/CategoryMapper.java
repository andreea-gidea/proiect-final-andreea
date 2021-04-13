package com.siit.proiectfinalandreea.plantshop.mapper;

import com.siit.proiectfinalandreea.plantshop.entity.CategoryEntity;
import com.siit.proiectfinalandreea.plantshop.model.CategoryDto;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto mapEntityToDto(CategoryEntity source);

    CategoryEntity mapDtoToEntity(CategoryDto source);

    List<CategoryDto> mapListEntityToListDto(List<CategoryEntity> source);

    List<CategoryEntity> mapListDtoToListEntity(List<CategoryDto> source);


}
