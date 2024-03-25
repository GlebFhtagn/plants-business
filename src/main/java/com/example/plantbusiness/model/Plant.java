package com.example.plantbusiness.model;

import com.example.plantbusiness.model.articles.Pot;
import com.example.plantbusiness.model.articles.Seed;
import com.example.plantbusiness.model.articles.Soil;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Objects;

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
    double price;

    @ManyToOne(fetch = FetchType.LAZY)
    Pot pot;

    @ManyToOne(fetch = FetchType.LAZY)
    Seed seed;

    @ManyToOne(fetch = FetchType.LAZY)
    Soil soil;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Plant plant = (Plant) o;
        return Double.compare(plant.price, price) == 0 && id.equals(plant.id) && Objects.equals(name, plant.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, price);
    }
}
