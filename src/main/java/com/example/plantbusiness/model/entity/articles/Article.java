package com.example.plantbusiness.model.entity.articles;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDateTime;


@Entity @Table(name = "ARTICLES") @Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "article_type",
        discriminatorType = DiscriminatorType.STRING)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Article extends AbstractPersistable<Long>{

    String name;

    String description;

    Long barcode;

    double price;

    LocalDateTime expirationDate;

    double weight;
}
