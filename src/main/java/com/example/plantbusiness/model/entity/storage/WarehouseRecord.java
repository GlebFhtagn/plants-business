package com.example.plantbusiness.model.entity.storage;

import com.example.plantbusiness.model.entity.articles.Article;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Map;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseRecord extends AbstractPersistable<Long> {

    //на какой id будет ссылаться эта таблица
//    @OneToOne
//    Article article;

    int quantity;

}
