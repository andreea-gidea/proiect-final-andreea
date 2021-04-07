package com.siit.proiectfinalandreea.plantshop.repository;

import com.siit.proiectfinalandreea.plantshop.domain.entity.OrderEntity;
import com.siit.proiectfinalandreea.plantshop.domain.entity.PlantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
