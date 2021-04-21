package com.siit.proiectfinalandreea.plantshop.service;


import com.siit.proiectfinalandreea.plantshop.exception.EmptyFileException;
import com.siit.proiectfinalandreea.plantshop.exception.PlantNotFoundException;
import com.siit.proiectfinalandreea.plantshop.mapper.PlantMapper;
import com.siit.proiectfinalandreea.plantshop.model.PlantCreateDto;
import com.siit.proiectfinalandreea.plantshop.model.PlantsDto;
import com.siit.proiectfinalandreea.plantshop.repository.PlantRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlantService {

    private final PlantRepository plantRepository;
    private final PlantMapper plantMapper;
    private final CategoryService categoryService;

    public List<PlantsDto> getPlants() {
        return plantMapper.mapListEntityToListDto(plantRepository.findAll());
    }

    public PlantsDto getPlant(Integer plantId) {
        return plantMapper.mapEntityToDto(plantRepository.findById(plantId).orElseThrow(() -> new PlantNotFoundException("No plant for given ID  " + plantId)));
    }

    @Transactional
    public List<PlantsDto> createPlantsReturnListDto(List<PlantCreateDto>plantsToCreate){
        List<PlantsDto>plantsDtos = plantsToCreate.stream().map(plantMapper::mapPlantCreateDtoToEntity)
                .map(plantRepository::save)
                .map(plantMapper::mapEntityToDto)
                .collect(Collectors.toList());
        return plantsDtos;
    }

    @SneakyThrows
    @Transactional
    public List<PlantsDto> createPlantsFromCSV(MultipartFile file){

        if (file.isEmpty()){
            throw new EmptyFileException("The given file is empty");
        }
        byte[] bytes = file.getBytes();
        String fileContent = new String(bytes);
        String[] rows = fileContent.split("\r\n");

        List<PlantCreateDto> toCreate = new ArrayList<>();

        for(String row : rows){
            String[] rowSplit = row.split(",");
            if (rowSplit.length != 0) {
                PlantCreateDto plantToCreateDto = PlantCreateDto.builder()
                        .plantName(rowSplit[0])
                        .potDimension(Integer.valueOf(rowSplit[1]))
                        .category(categoryService.getCategory(Integer.valueOf(rowSplit[2])))
                        .price(Integer.valueOf(rowSplit[3]))
                        .build();
                toCreate.add(plantToCreateDto);
            }
        }
        return createPlantsReturnListDto(toCreate);
    }
}
