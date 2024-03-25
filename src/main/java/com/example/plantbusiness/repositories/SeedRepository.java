package com.example.plantbusiness.repositories;

import com.example.plantbusiness.model.articles.Seed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeedRepository extends JpaRepository<Seed, Long> {
}
