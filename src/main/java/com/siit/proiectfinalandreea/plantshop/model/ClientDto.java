package com.siit.proiectfinalandreea.plantshop.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
