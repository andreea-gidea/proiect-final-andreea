package com.siit.proiectfinalandreea.plantshop.controller;


import com.siit.proiectfinalandreea.plantshop.model.PlantsDto;
import com.siit.proiectfinalandreea.plantshop.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plants")
public class PlantController {

    private final PlantService plantService;

    @GetMapping()
    public List<PlantsDto> getPlants() {
        return plantService.getPlants();
    }

    @GetMapping("/{plantID}")
    public PlantsDto getPlant(@PathVariable(name = "plantID") Integer plantId){
        return plantService.getPlant(plantId);
    }
    @PostMapping("/csv-upload")
    public List<PlantsDto> createPlants(@RequestParam(name = "csv-file") MultipartFile file){
        return plantService.createPlantsFromCSV(file);
    }
}
