package com.example.plantbusiness.model.articles;

import com.example.plantbusiness.model.SoilType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("sl")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Soil extends Article{

    Long volume;

    @ManyToOne
    SoilType soilType;

    @Builder(builderMethodName = "soilBuilder")
    public Soil(String name, String description, Long barcode, double price, LocalDateTime expirationDate,
                double weight, Long volume, SoilType soilType){
        super(name, description, barcode, price, expirationDate, weight);
        setVolume(volume);
        setSoilType(soilType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Soil soil = (Soil) o;
        return Objects.equals(volume, soil.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume);
    }
}
