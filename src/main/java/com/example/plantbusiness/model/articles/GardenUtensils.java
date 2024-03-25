package com.example.plantbusiness.model.articles;

import com.example.plantbusiness.model.Material;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@DiscriminatorValue("u")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GardenUtensils extends Article {

    Long unitsInPack;

    @ManyToOne(fetch = FetchType.LAZY)
    Material material;

    @Builder(builderMethodName = "utensilsBuilder")
    public GardenUtensils(String name, String description, Long barcode, double price, LocalDateTime expirationDate,
                          double weight, Material material, Long unitsInPack){
        super(name, description, barcode, price, expirationDate, weight);
        setMaterial(material);
        setUnitsInPack(unitsInPack);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GardenUtensils object = (GardenUtensils) o;
        return Objects.equals(unitsInPack, object.getUnitsInPack());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), unitsInPack);
    }
}
