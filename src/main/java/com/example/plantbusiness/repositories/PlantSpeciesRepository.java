package com.example.plantbusiness.repositories;

import com.example.plantbusiness.model.PlantSpecies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantSpeciesRepository extends JpaRepository<PlantSpecies, Long> {
}
