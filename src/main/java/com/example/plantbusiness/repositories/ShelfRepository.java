package com.example.plantbusiness.repositories;

import com.example.plantbusiness.model.storage.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelfRepository extends JpaRepository<Shelf, Long> {
}
