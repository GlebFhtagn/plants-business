package com.example.plantbusiness.model.articles;

import com.example.plantbusiness.model.Material;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("p")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pot extends Article {

    Long volume;

    @ManyToOne
    Material material;

    @Builder(builderMethodName = "potBuilder")
    public Pot(String name, String description, Long barcode, double price, LocalDateTime expirationDate,
               double weight, Long volume, Material material){
        super(name, description, barcode, price, expirationDate, weight);
        setVolume(volume);
        setMaterial(material);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pot pot = (Pot) o;
        return Objects.equals(volume, pot.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume);
    }
}
