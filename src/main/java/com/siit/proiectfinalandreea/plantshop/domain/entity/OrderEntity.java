package com.siit.proiectfinalandreea.plantshop.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Column(name = "order_NO")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderNumber;

    @Column(name = "order_date")
    @Builder.Default
    private LocalDate oreringDate = LocalDate.now();

    @Column(name = "delivery_date")
    @Builder.Default
    private LocalDate dateOfDelivery = LocalDate.now().plusDays(1);

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntity clientEntity;

    @ManyToMany(mappedBy = "plants")
    Set<OrdersWithPlantsEntity> ordersWithPlantsEntities;


}
