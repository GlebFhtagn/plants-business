package com.example.plantbusiness.model.entity.articles;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity @Table(name = "articles")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Article extends AbstractPersistable<Long>{

    String name;

    String description;

    Long barcode;

    double price;

}
