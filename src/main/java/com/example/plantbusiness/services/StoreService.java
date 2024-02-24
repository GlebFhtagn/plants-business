package com.example.plantbusiness.services;

import com.example.plantbusiness.model.entity.Plant;
import com.example.plantbusiness.model.entity.articles.Article;
import com.example.plantbusiness.repositories.ArticleRepository;
import com.example.plantbusiness.repositories.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ShelfRepository shelfRepository;

    public static Optional<Article> searchArticle(Object... params){ return null; }

    public static Optional<Plant> searchPlant(Object... params){ return null; }

    public static void sellArticle(Article article){}

    public static void sellPlant(Plant plant){}

    public static List<Plant> stockStore(){ return null; }
}
