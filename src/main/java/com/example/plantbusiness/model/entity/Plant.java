package com.example.plantbusiness.model.entity;

import com.example.plantbusiness.model.entity.articles.Pot;
import com.example.plantbusiness.model.entity.articles.Seed;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.UUID;

@Entity
@Table(name = "plants")
@NoArgsConstructor
@Getter
@Setter
public class Plant extends AbstractPersistable<Long> {

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
