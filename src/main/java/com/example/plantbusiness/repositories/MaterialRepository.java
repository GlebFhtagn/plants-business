package com.example.plantbusiness.repositories;

import com.example.plantbusiness.model.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}
