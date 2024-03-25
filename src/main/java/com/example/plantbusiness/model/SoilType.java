package com.example.plantbusiness.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity @Data @Table(name = "SOIL_TYPE")
@NoArgsConstructor
@AllArgsConstructor
public class SoilType extends AbstractPersistable<Long> {

    String name;
}
