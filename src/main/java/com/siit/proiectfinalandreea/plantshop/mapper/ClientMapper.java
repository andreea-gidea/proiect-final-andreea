package com.siit.proiectfinalandreea.plantshop.mapper;

import com.siit.proiectfinalandreea.plantshop.entity.CategoryEntity;
import com.siit.proiectfinalandreea.plantshop.entity.ClientEntity;
import com.siit.proiectfinalandreea.plantshop.model.CategoryDto;
import com.siit.proiectfinalandreea.plantshop.model.ClientDto;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDto mapEntityToDto(ClientEntity source);

    ClientEntity mapDtoToEntity(ClientDto source);

    List<ClientDto> mapListEntityToListDto(List<ClientEntity> source);

    List<ClientEntity> mapListDtoToListEntity(List<ClientDto> source);


}
