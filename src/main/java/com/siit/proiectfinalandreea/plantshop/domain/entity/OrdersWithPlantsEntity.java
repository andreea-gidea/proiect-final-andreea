package com.siit.proiectfinalandreea.plantshop.domain.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;


@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode
@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "orders_with_plants")
public class OrdersWithPlantsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nr_crt")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="plant_id")
    private PlantEntity plantEntity;

    @Column(name = "number_of_plants")
    private Integer numberOfPlants;

    public OrdersWithPlantsEntity() {
    }

    public OrdersWithPlantsEntity(OrderEntity orderEntity, PlantEntity plantEntity, Integer numberOfPlants) {
        this.orderEntity = orderEntity;
        this.plantEntity = plantEntity;
        this.numberOfPlants = numberOfPlants;
    }

}
