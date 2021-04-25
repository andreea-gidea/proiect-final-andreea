package com.siit.proiectfinalandreea.plantshop.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CategoryDtoCreateRequest {

    @NotBlank
    private String categoryName;

}
