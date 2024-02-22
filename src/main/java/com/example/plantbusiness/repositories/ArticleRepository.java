package com.example.plantbusiness.repositories;

import com.example.plantbusiness.model.entity.articles.Article;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
