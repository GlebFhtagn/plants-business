package com.example.plantbusiness.model.entity;

import com.example.plantbusiness.model.entity.articles.Pot;
import com.example.plantbusiness.model.entity.articles.Seed;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.UUID;

@Entity
@Table(name = "plants")
@NoArgsConstructor
@Getter
@Setter
public class Plant extends AbstractPersistable<UUID> {

    @Id
    @GeneratedValue
    Long id;

    @Column
    String name;

    @Column
    int price;

    @ManyToOne
    Pot pot;

    @ManyToOne
    Seed seed;
}
