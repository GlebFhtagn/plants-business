package com.example.plantbusiness.model.entity.articles;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity @Table(name = "ARTICLES") @Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article extends AbstractPersistable<Long>{

    String name;

    String description;

    Long barcode;

    double price;

}
