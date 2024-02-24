package com.example.plantbusiness.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity @Data @Table(name = "MATERIALS")
@NoArgsConstructor
@AllArgsConstructor
public class Material extends AbstractPersistable<Long> {

    @NotNull
    @NotBlank
    @Column(unique = true)
    String name;
}
