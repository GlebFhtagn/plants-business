package com.example.plantbusiness.model.entity.articles;

import com.example.plantbusiness.model.entity.Material;
import com.example.plantbusiness.model.entity.SoilType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

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
}
