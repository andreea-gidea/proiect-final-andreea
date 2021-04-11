package com.siit.proiectfinalandreea.plantshop.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.siit.proiectfinalandreea.plantshop.domain.entity.ClientEntity;
import com.siit.proiectfinalandreea.plantshop.domain.entity.OrdersWithPlantsEntity;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {

    private Integer orderNumber;

    private LocalDate orderingDate = LocalDate.now();

    private LocalDate dateOfDelivery = LocalDate.now().plusDays(1);

    private ClientDto clientDto;

    private List<OrdersWithPlantsDto> tags = new ArrayList<>();

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

}
