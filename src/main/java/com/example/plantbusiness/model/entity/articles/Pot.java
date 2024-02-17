package com.example.plantbusiness.model.entity.articles;

import com.example.plantbusiness.model.entity.Material;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.UUID;


@Table(name = "pots")
@Entity
public class Pot extends Article {

    int volume;

    double price;

    String name;

    @ManyToOne
    Material material;

}
