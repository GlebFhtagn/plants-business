package com.example.plantbusiness.model.storage;

import com.example.plantbusiness.model.articles.Article;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity @Data @Table(name = "WAREHOUSE_RECORDS")
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseRecord extends AbstractPersistable<Long> {

    @OneToOne(fetch = FetchType.EAGER)
    Article article;

    Long quantity;

}
