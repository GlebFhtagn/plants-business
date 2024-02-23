package com.example.plantbusiness.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity @Data @Table(name = "MATERIALS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Material extends AbstractPersistable<Long> {

    String name;
}
