package com.siit.proiectfinalandreea.plantshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
@AllArgsConstructor

public class CategoryDto {

    private int id;

    private String categoryName;

}
