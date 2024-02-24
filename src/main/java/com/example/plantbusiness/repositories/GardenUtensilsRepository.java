package com.example.plantbusiness.repositories;

import com.example.plantbusiness.model.entity.articles.GardenUtensils;
import com.example.plantbusiness.model.entity.articles.Seed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GardenUtensilsRepository extends JpaRepository<GardenUtensils, Long> {
}
