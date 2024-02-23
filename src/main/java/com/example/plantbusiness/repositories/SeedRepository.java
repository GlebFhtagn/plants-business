package com.example.plantbusiness.repositories;

import com.example.plantbusiness.model.entity.articles.Seed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SeedRepository extends JpaRepository<Seed, Long> {
}
