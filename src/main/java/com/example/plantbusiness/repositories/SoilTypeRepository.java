package com.example.plantbusiness.repositories;

import com.example.plantbusiness.model.entity.SoilType;
import com.example.plantbusiness.model.entity.articles.Seed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoilTypeRepository extends JpaRepository<SoilType, Long> {
}
