package com.siit.proiectfinalandreea.plantshop.repository;

import com.siit.proiectfinalandreea.plantshop.entity.OrderEntity;
import com.siit.proiectfinalandreea.plantshop.entity.OrdersWithPlantsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderWithPlantsRepository extends JpaRepository<OrdersWithPlantsEntity, Integer> {
}
