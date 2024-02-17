package com.example.plantbusiness.model.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Material extends AbstractPersistable<Long> {

    String name;
}
