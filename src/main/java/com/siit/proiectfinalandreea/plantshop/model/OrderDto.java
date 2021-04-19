package com.siit.proiectfinalandreea.plantshop.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {

    private Integer orderNumber;

    private LocalDate orderingDate = LocalDate.now();

    private LocalDate dateOfDelivery = LocalDate.now().plusDays(1);

    private ClientDto client;

    private List<OrdersWithPlantsDto> plants = new ArrayList<>();

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

}
