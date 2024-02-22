package com.example.plantbusiness.model.entity.articles;

import com.example.plantbusiness.model.entity.PlantSpecies;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Table(name = "seeds")
@Entity
public class Seed extends AbstractPersistable<Long> {

    String name;

    int weight;

    @ManyToOne
    PlantSpecies species;

    @OneToOne
    Article article;
}
