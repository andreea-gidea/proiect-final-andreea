package com.siit.proiectfinalandreea.plantshop.mapper;

import com.siit.proiectfinalandreea.plantshop.entity.OrderEntity;
import com.siit.proiectfinalandreea.plantshop.entity.PlantEntity;
import com.siit.proiectfinalandreea.plantshop.model.OrderDto;
import com.siit.proiectfinalandreea.plantshop.model.PlantsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(uses = OrderWithPlantsMapper.class, componentModel = "spring")
public interface OrderMapper {

    OrderDto mapEntityToDto(OrderEntity source);

    List<OrderDto> mapListEntityToListDto(List<OrderEntity> source);

}
