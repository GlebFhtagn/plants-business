package com.example.plantbusiness.model.entity.articles;

import com.example.plantbusiness.model.entity.PlantSpecies;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "seeds")
@Entity
public class Seed extends Article {

    int weight;

    double price;

    String name;

    @ManyToOne
    PlantSpecies species;

    String description;
}
