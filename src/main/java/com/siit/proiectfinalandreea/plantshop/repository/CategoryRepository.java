package com.siit.proiectfinalandreea.plantshop.repository;

import com.siit.proiectfinalandreea.plantshop.domain.entity.CategoryEntity;
import com.siit.proiectfinalandreea.plantshop.domain.entity.PlantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
