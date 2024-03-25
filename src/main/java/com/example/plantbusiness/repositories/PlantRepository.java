package com.example.plantbusiness.repositories;

import com.example.plantbusiness.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
