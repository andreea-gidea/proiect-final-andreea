package com.siit.proiectfinalandreea.plantshop.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "plants")
public class PlantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "plant_name")
    private String plantName;

    @Column(name = "pot_dimension")
    private Integer potDimension;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryEntity categoryEntity;

    private Integer price;
    @OneToMany(
            mappedBy = "plantEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrdersWithPlantsEntity> orders = new ArrayList<>();

}
