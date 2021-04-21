package com.siit.proiectfinalandreea.plantshop.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode
@Getter
@Setter
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
    private OrderEntity order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="plant_id")
    private PlantEntity plant;

    @Column(name = "number_of_plants")
    private Integer numberOfPlants;

    public OrdersWithPlantsEntity() {
    }

    public OrdersWithPlantsEntity(OrderEntity orderEntity, PlantEntity plantEntity, Integer numberOfPlants) {
        this.order = orderEntity;
        this.plant = plantEntity;
        this.numberOfPlants = numberOfPlants;
    }

}
