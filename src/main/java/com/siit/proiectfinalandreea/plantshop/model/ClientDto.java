package com.siit.proiectfinalandreea.plantshop.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientDto {
 private int id;
 private String clientName;
 private LocalDate dateCreatedAcc;
private  String clientMail;
private String addressOfDelivery;
}
