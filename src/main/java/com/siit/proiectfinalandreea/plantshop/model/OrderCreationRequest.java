package com.siit.proiectfinalandreea.plantshop.model;

import lombok.Data;

import java.util.List;

@Data

public class OrderCreationRequest {

    private List<PlantInfo> plantInfos;

    private String title;//vezi daca ai nevoie de campul asta

}
