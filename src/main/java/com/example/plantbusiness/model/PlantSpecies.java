package com.example.plantbusiness.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity @Table(name = "SPECIES") @Data
@NoArgsConstructor
@AllArgsConstructor
public class PlantSpecies extends AbstractPersistable<Long> {

    String name;
}
