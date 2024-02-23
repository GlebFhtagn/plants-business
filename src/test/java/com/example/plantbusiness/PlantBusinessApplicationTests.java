package com.example.plantbusiness;

import com.example.plantbusiness.model.entity.Material;
import com.example.plantbusiness.model.entity.Plant;
import com.example.plantbusiness.model.entity.PlantSpecies;
import com.example.plantbusiness.model.entity.articles.Article;
import com.example.plantbusiness.model.entity.articles.Pot;
import com.example.plantbusiness.model.entity.articles.Seed;
import com.example.plantbusiness.model.entity.storage.Shelf;
import com.example.plantbusiness.model.entity.storage.WarehouseRecord;
import com.example.plantbusiness.repositories.ArticleRepository;
import com.example.plantbusiness.repositories.MaterialRepository;
import com.example.plantbusiness.repositories.PotRepository;
import com.example.plantbusiness.repositories.WarehouseRecordRepository;
import com.example.plantbusiness.repositories.PlantRepository;
import com.example.plantbusiness.repositories.PlantSpeciesRepository;
import com.example.plantbusiness.repositories.SeedRepository;
import com.example.plantbusiness.repositories.ShelfRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@EntityScan(basePackages = {"com.example.plantbusiness.model.entity"})
class PlantBusinessApplicationTests {

    @Autowired

    MaterialRepository materialRepository;
    @Autowired

    PlantSpeciesRepository plantSpeciesRepository;
    @Autowired

    PotRepository potRepository;
    @Autowired

    SeedRepository seedRepository;
    @Autowired

    ArticleRepository articleRepository;
    @Autowired
    WarehouseRecordRepository wrRepository;
    @Autowired

    PlantRepository plantRepository;
    @Autowired
    ShelfRepository shelfRepository;


    static Material TEST_MATERIAL = Material.builder().name("Ceramic").build();
    static PlantSpecies TEST_SPECIES = PlantSpecies.builder().name("Garganza").build();
    static Article TEST_ARTICLE = Article.builder()
            .name("Article Test Pot")
            .description("This is test pot, not for sale")
            .barcode(14352345L)
            .price(1000)
            .build();
    static Article TEST_ARTICLE_1 = Article.builder()
            .name("Article Test Seed")
            .description("This is test seeds, not for sale")
            .barcode(14352345L)
            .price(1000)
            .build();
    static Pot TEST_POT = Pot.builder()
            .name("Actual Physical Pot")
            .material(TEST_MATERIAL)
            .volume(18888L)
            .article(TEST_ARTICLE)
            .build();
    static Seed TEST_SEED = Seed.builder()
            .name("Actual Physical sEED")
            .species(TEST_SPECIES)
            .article(TEST_ARTICLE_1)
            .build();


    @BeforeAll
    public static void initTestDataObjects(){
    }

    private void batchSave(Object... entities){
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
    @Test
    @Transactional
    void stock() {
        batchSave(TEST_MATERIAL, TEST_SPECIES, TEST_ARTICLE, TEST_ARTICLE_1, TEST_POT, TEST_SEED);

        Plant plant = new Plant();
        Plant plant1 = new Plant();
        plant.setPot(TEST_POT);
        plant.setSeed(TEST_SEED);
        plant.setPrice(TEST_POT.getArticle().getPrice() + TEST_SEED.getArticle().getPrice() + 100);

        batchSave(plant, plant1);


        Shelf shelf = new Shelf();
        shelf.setName("GARGANZAS SHELF");
        shelf.setPlantList(List.of(plant, plant1));

        shelfRepository.save(shelf);

        List<Shelf> shelfs = shelfRepository.findAll();

        for (Shelf shelf1 : shelfs) {
            List<Plant> plantList = shelf1.getPlantList();
            for (Plant plant2 : plantList) {
                System.out.println(plant2.getName());

            }
        }

        WarehouseRecord wr = new WarehouseRecord(TEST_ARTICLE, 15);
        wrRepository.save(wr);

        var resPot = potRepository.findById(TEST_POT.getId()).orElse(null);
        var resArticle = articleRepository.findById(TEST_ARTICLE.getId()).orElse(null);
        var resWr = wrRepository.findById(wr.getId()).orElse(null);

        Assertions.assertEquals(TEST_POT, resPot);
        Assertions.assertEquals(TEST_ARTICLE, resArticle);
        Assertions.assertEquals(wr, resWr);
    }

}
