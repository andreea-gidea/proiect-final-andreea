package com.siit.proiectfinalandreea.plantshop.domain.controller;

import com.siit.proiectfinalandreea.plantshop.domain.model.CategoryDto;
import com.siit.proiectfinalandreea.plantshop.domain.model.PlantsDto;
import com.siit.proiectfinalandreea.plantshop.service.CategoryService;
import com.siit.proiectfinalandreea.plantshop.service.PlantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/plants")
public class PlantController {

    private final PlantService plantService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PlantsDto> petAllPlants(){
        return plantService.getAllPlants();
    }
}
