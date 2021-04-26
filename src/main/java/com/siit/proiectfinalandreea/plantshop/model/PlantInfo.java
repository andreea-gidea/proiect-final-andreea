package com.siit.proiectfinalandreea.plantshop.model;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class PlantInfo {

    private Integer plantId;

    @Min(1)
    private Integer quantity;

}
