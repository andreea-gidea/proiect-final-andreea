package com.siit.proiectfinalandreea.plantshop.model;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
@Builder
public class PlantCreateDto {

    @NotBlank
    private String plantName;

    @NotBlank
    private Integer potDimension;

    @NotBlank
    private CategoryDto category;

    @NotBlank
    private Integer price;

}
