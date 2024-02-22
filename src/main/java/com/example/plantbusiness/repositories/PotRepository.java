package com.example.plantbusiness.repositories;

import com.example.plantbusiness.model.entity.articles.Pot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PotRepository extends JpaRepository<Pot, Long> {
}
