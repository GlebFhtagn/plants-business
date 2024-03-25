package com.example.plantbusiness.repositories;

import com.example.plantbusiness.model.articles.Article;
import com.example.plantbusiness.model.storage.WarehouseRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRecordRepository extends JpaRepository<WarehouseRecord, Long> {

    WarehouseRecord findByArticle(Article article);
}
