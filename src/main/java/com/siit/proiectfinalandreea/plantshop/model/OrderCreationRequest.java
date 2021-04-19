package com.siit.proiectfinalandreea.plantshop.model;

import lombok.Data;

import java.util.List;

@Data

public class OrderCreationRequest {

    private Integer clientId;

    private List<PlantInfo> plantInfos;


}
