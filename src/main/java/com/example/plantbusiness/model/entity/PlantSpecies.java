package com.example.plantbusiness.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity @Table(name = "SPECIES") @Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlantSpecies extends AbstractPersistable<Long> {

    String name;
}
