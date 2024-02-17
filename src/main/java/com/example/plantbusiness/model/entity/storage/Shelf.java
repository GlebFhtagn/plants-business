package com.example.plantbusiness.model.entity.storage;

import com.example.plantbusiness.model.entity.Plant;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.List;

@Table(name = "shelfs")
@NoArgsConstructor
@AllArgsConstructor
public class Shelf extends AbstractPersistable<Long> {

    String name;

    @OneToMany
    List<Plant> plantList;
}
