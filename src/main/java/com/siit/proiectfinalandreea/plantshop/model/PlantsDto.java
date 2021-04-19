package com.siit.proiectfinalandreea.plantshop.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PlantsDto {

    private Integer id;

    private String plantName;

    private Integer potDimension;

    private CategoryDto category;

    private Integer price;

    private List<OrdersWithPlantsDto> orders = new ArrayList<>();
}
