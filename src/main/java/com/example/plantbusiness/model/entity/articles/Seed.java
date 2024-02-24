package com.example.plantbusiness.model.entity.articles;

import com.example.plantbusiness.model.entity.PlantSpecies;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDateTime;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("s")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Seed extends Article {

    @ManyToOne
    PlantSpecies species;

    @Builder(builderMethodName = "seedBuilder")
    public Seed(String name, String description, Long barcode, double price, LocalDateTime expirationDate,
                double weight, PlantSpecies species){
        super(name, description, barcode, price, expirationDate, weight);
        setSpecies(species);
    }
}