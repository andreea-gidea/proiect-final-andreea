package com.siit.proiectfinalandreea.plantshop.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class ClientDto {
    private int id;
    @NotBlank
    private String clientName;
    private LocalDate dateCreatedAcc;
    @NotBlank
    private String clientMail;
    @NotBlank
    private String addressOfDelivery;
}
