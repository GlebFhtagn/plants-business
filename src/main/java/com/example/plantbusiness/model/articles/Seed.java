package com.example.plantbusiness.model.articles;

import com.example.plantbusiness.model.PlantSpecies;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("s")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Seed extends Article {

    @ManyToOne(fetch = FetchType.LAZY)
    PlantSpecies species;

    @Builder(builderMethodName = "seedBuilder")
    public Seed(String name, String description, Long barcode, double price, LocalDateTime expirationDate,
                double weight, PlantSpecies species){
        super(name, description, barcode, price, expirationDate, weight);
        setSpecies(species);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}