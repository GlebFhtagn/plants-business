package com.example.plantbusiness.model.entity.articles;

import com.example.plantbusiness.model.entity.Material;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity @Table(name = "pots") @Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pot extends AbstractPersistable<Long> {

    String name;

    Long volume;

    @ManyToOne
    Material material;

    @OneToOne
    Article article;

}
