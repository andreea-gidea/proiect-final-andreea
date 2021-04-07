package com.siit.proiectfinalandreea.plantshop.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders_with_plants")
public class OrdersWithPlantsEntity {
    @Column(name = "nr_crt")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nrCrt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "oreder_NO")
    private OrderEntity orderEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plant_id", referencedColumnName = "id")
    private PlantEntity plantEntity;

    @Column(name = "plant_number")
    private Integer numberOfPlants;


}
