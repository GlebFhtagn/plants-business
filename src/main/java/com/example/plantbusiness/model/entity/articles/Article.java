package com.example.plantbusiness.model.entity.articles;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
@NoArgsConstructor
@Getter
@Setter
public abstract class Article extends AbstractPersistable<Long> {
}
