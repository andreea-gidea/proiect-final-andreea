package com.siit.proiectfinalandreea.plantshop.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class ClientUpdateRequest {

    private Integer id;
    private String clientName;
    private String clientMail;
    private String addressOfDelivery;
}
