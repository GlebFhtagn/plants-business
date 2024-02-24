package com.example.plantbusiness.model.entity.articles;

import com.example.plantbusiness.model.entity.Material;
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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("u")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GardenUtensils extends Article {

    Long unitsInPack;

    @ManyToOne
    Material material;

    @Builder(builderMethodName = "utensilsBuilder")
    public GardenUtensils(String name, String description, Long barcode, double price, LocalDateTime expirationDate,
                          double weight, Material material, Long unitsInPack){
        super(name, description, barcode, price, expirationDate, weight);
        setMaterial(material);
        setUnitsInPack(unitsInPack);
    }
}
