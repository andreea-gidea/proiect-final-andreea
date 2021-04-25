package com.siit.proiectfinalandreea.plantshop.mapper;

import com.siit.proiectfinalandreea.plantshop.entity.CategoryEntity;
import com.siit.proiectfinalandreea.plantshop.model.CategoryDto;
import com.siit.proiectfinalandreea.plantshop.model.CategoryDtoCreateRequest;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto mapEntityToDto(CategoryEntity source);

    CategoryEntity mapDtoToEntity(CategoryDto source);

    CategoryEntity mapDtoCreateRequestToEntity(CategoryDtoCreateRequest source);

    List<CategoryDto> mapListEntityToListDto(List<CategoryEntity> source);

    List<CategoryEntity> mapListDtoToListEntity(List<CategoryDto> source);


}
