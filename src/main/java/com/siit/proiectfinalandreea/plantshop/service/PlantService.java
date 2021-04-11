package com.siit.proiectfinalandreea.plantshop.service;

import com.siit.proiectfinalandreea.plantshop.domain.model.CategoryDto;
import com.siit.proiectfinalandreea.plantshop.domain.model.PlantsDto;
import com.siit.proiectfinalandreea.plantshop.mapper.CategoryEntityToCategoryDtoMapper;
import com.siit.proiectfinalandreea.plantshop.mapper.PlantEntityToPlantDtoMapper;
import com.siit.proiectfinalandreea.plantshop.repository.CategoryRepository;
import com.siit.proiectfinalandreea.plantshop.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class PlantService {
    private final PlantEntityToPlantDtoMapper plantEntityToPlantDtoMapper;
    private final PlantRepository plantRepository;


    @Transactional(readOnly = true)
    public List<PlantsDto> getAllPlants() {
        return plantRepository.findAll()
                .stream()
                .map(plantEntity -> plantEntityToPlantDtoMapper.mapEntityToDto(plantEntity))
                .collect(toList());
    }

}
