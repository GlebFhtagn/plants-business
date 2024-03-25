package com.example.plantbusiness.model.articles;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDateTime;
import java.util.Objects;


@Entity @Table(name = "ARTICLES") @Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
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

//    protected Article(String name, String description, Long barcode, double price, LocalDateTime expirationDate, double weight) {
//        this.name = name;
//        this.description = description;
//        this.barcode = barcode;
//        this.price = price;
//        this.expirationDate = expirationDate;
//        this.weight = weight;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Article article = (Article) o;
        return Double.compare(article.price, price) == 0 &&
                Double.compare(article.weight, weight) == 0 &&
                name.equals(article.name) &&
                Objects.equals(description, article.description) &&
                Objects.equals(barcode, article.barcode) &&
                Objects.equals(expirationDate, article.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, description, barcode, price, expirationDate, weight);
    }
}
