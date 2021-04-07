package com.siit.proiectfinalandreea.plantshop.repository;

import com.siit.proiectfinalandreea.plantshop.domain.entity.ClientEntity;
import com.siit.proiectfinalandreea.plantshop.domain.entity.PlantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
}
