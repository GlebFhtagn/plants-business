package com.example.plantbusiness.services;

import com.example.plantbusiness.model.entity.articles.Article;
import com.example.plantbusiness.repositories.WarehouseRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRecordRepository repository;

    public static void stockWarehouse(List<Map<Article, Long>> arrivedSupply){}

    public static List<Map<Article, Long>> productAccounting(){ return null; }

    public static List<Map<Article, Long>> stockStoreAndGiveWhatsLeft(List<Map<Article, Long>> articlesToStock){ return null; }
}
