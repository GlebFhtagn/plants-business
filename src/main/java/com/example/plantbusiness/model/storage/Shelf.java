package com.example.plantbusiness.model.storage;

import com.example.plantbusiness.model.Plant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.List;
import java.util.Objects;

@Entity @Table(name = "SHELFS") @Data
@NoArgsConstructor
@AllArgsConstructor
public class Shelf extends AbstractPersistable<Long> {

    String name;

    @OneToMany(fetch = FetchType.LAZY)
    List<Plant> plantList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Shelf shelf = (Shelf) o;
        return Objects.equals(name, shelf.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
