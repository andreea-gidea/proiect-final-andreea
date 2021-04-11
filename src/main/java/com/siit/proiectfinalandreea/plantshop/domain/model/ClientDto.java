package com.siit.proiectfinalandreea.plantshop.domain.model;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Data
public class ClientDto {
 private int id;
 private String clientName;
 private LocalDate dateCreatedAcc;
private  String clientMail;
private String addressOfDelivery;
}
