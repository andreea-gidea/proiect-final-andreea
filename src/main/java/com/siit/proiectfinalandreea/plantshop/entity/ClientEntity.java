package com.siit.proiectfinalandreea.plantshop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "date_account")
//    @CreatedDate
    @Builder.Default
    private LocalDate dateCreatedAcc=LocalDate.now();

    @Column(name = "client_mail")
    private String clientMail;

    @Column(name = "delivery_address")
    private String addressOfDelivery;

}