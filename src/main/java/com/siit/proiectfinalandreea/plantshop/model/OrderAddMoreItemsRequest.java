package com.siit.proiectfinalandreea.plantshop.model;

import lombok.Data;

import java.util.List;

@Data

public class OrderAddMoreItemsRequest {

    private Integer orderId;

    private List<PlantInfo> plantInfos;


}
