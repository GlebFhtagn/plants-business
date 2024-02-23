package com.example.plantbusiness.model.entity.articles;

import com.example.plantbusiness.model.entity.PlantSpecies;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity @Table(name = "SEEDS") @Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Seed extends AbstractPersistable<Long> {

    String name;

    int weight;

    @ManyToOne
    PlantSpecies species;

    @OneToOne
    Article article;
}
