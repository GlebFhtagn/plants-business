package com.example.plantbusiness;

import com.example.plantbusiness.model.Material;
import com.example.plantbusiness.model.Plant;
import com.example.plantbusiness.model.PlantSpecies;
import com.example.plantbusiness.model.articles.Article;
import com.example.plantbusiness.model.articles.Pot;
import com.example.plantbusiness.model.articles.Seed;
import com.example.plantbusiness.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonDBMethods {

    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    PotRepository potRepository;

    @Autowired
    SeedRepository seedRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    WarehouseRecordRepository wrRepository;

    @Autowired
    PlantSpeciesRepository plantSpeciesRepository;

    @Autowired
    PlantRepository plantRepository;

    @Autowired
    ShelfRepository shelfRepository;

    void batchSave(Object... entities){
        for (Object entity : entities) {
            switch (entity.getClass().getSimpleName()) {
                case "Material" ->
                        materialRepository.save((Material) entity);
                case "PlantSpecies" ->
                        plantSpeciesRepository.save((PlantSpecies) entity);
                case "Article" ->
                        articleRepository.save((Article) entity);
                case "Pot" ->
                        potRepository.save((Pot) entity);
                case "Seed" ->
                        seedRepository.save((Seed) entity);
                case "Plant" ->
                        plantRepository.save((Plant) entity);

            }
        }
    }
}
