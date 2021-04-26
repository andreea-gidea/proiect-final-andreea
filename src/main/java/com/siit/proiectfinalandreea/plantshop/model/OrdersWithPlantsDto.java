package com.siit.proiectfinalandreea.plantshop.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdersWithPlantsDto {

    private Integer id;

    private OrderDto order;

    @Min(1)
    private int numberOfPlants;

    private PlantsDto Plant;

}
