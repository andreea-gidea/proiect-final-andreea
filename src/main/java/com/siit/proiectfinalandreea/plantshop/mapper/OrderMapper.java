package com.siit.proiectfinalandreea.plantshop.mapper;

import com.siit.proiectfinalandreea.plantshop.entity.OrderEntity;
import com.siit.proiectfinalandreea.plantshop.model.OrderDto;
import org.mapstruct.Mapper;


import java.util.List;


@Mapper(uses = {OrderWithPlantsMapper.class,ClientMapper.class}, componentModel = "spring")
public interface OrderMapper {

    OrderDto mapEntityToDto(OrderEntity source);

    List<OrderDto> mapListEntityToListDto(List<OrderEntity> source);

    OrderEntity mapDtoToEntity(OrderDto source);

}
