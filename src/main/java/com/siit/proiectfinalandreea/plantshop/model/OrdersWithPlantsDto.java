package com.siit.proiectfinalandreea.plantshop.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdersWithPlantsDto {

    private Integer id;

    private OrderDto order;

    private int numberOfPlants;

    private PlantsDto Plant;

}
