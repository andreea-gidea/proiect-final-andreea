package com.siit.proiectfinalandreea.plantshop.mapper;

import com.siit.proiectfinalandreea.plantshop.entity.OrderEntity;
import com.siit.proiectfinalandreea.plantshop.entity.OrdersWithPlantsEntity;
import com.siit.proiectfinalandreea.plantshop.model.OrderDto;
import com.siit.proiectfinalandreea.plantshop.model.OrdersWithPlantsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(uses = PlantMapper.class, componentModel = "spring")
public interface OrderWithPlantsMapper {

    @Mapping(target = "order", ignore = true)
    OrdersWithPlantsDto mapEntityToDto(OrdersWithPlantsEntity source);

}
