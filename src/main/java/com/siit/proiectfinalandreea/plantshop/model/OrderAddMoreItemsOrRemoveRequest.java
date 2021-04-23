package com.siit.proiectfinalandreea.plantshop.model;

import lombok.Data;

import java.util.List;

@Data

public class OrderAddMoreItemsOrRemoveRequest {

    private Integer orderId;

    private List<PlantInfo> plantInfos;


}
