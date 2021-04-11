package com.siit.proiectfinalandreea.plantshop.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlantsDto {

    private Integer id;

    private String plantName;

    private Integer potDimension;

    private CategoryDto category;

    private Integer price;

    private List<OrdersWithPlantsDto> orders = new ArrayList<>();
}
