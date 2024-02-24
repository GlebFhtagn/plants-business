package com.example.plantbusiness.repositories;

import com.example.plantbusiness.model.entity.articles.Seed;
import com.example.plantbusiness.model.entity.articles.Soil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoilRepository extends JpaRepository<Soil, Long> {
}
