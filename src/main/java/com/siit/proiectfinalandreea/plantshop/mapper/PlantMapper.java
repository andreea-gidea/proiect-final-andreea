package com.siit.proiectfinalandreea.plantshop.mapper;

import com.siit.proiectfinalandreea.plantshop.entity.OrderEntity;
import com.siit.proiectfinalandreea.plantshop.entity.PlantEntity;
import com.siit.proiectfinalandreea.plantshop.model.OrderDto;
import com.siit.proiectfinalandreea.plantshop.model.PlantCreateDto;
import com.siit.proiectfinalandreea.plantshop.model.PlantsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface PlantMapper {

    @Mapping(target = "orders", ignore = true)
    PlantsDto mapEntityToDto(PlantEntity source);

    List<PlantsDto> mapListEntityToListDto(List<PlantEntity> source);

    PlantEntity mapDtoToEntity(PlantsDto source);

    PlantEntity mapPlantCreateDtoToEntity(PlantCreateDto source);

}
