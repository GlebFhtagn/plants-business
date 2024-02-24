package com.example.plantbusiness.model.entity.articles;

import com.example.plantbusiness.model.entity.Material;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDateTime;

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
}
