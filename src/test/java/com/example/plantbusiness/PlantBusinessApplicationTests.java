package com.example.plantbusiness;

import com.example.plantbusiness.model.entity.Material;
import com.example.plantbusiness.model.entity.articles.Article;
import com.example.plantbusiness.model.entity.articles.Pot;
import com.example.plantbusiness.model.entity.storage.WarehouseRecord;
import com.example.plantbusiness.repositories.ArticleRepository;
import com.example.plantbusiness.repositories.MaterialRepository;
import com.example.plantbusiness.repositories.PotRepository;
import com.example.plantbusiness.repositories.WarehouseRecordRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@EntityScan(basePackages = {"com.example.plantbusiness.model.entity"})
class PlantBusinessApplicationTests {

    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    PotRepository potRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    WarehouseRecordRepository wrRepository;
    static Material TEST_MATERIAL;
    static Article TEST_ARTICLE;
    static Pot TEST_POT;

    @BeforeAll
    public static void initTestDataObjects(){
        TEST_MATERIAL = new Material("Ceramic");

        TEST_ARTICLE = new Article();
        TEST_ARTICLE.setName("Pot Name 1234");
        TEST_ARTICLE.setDescription("Pot Descr");
        TEST_ARTICLE.setPrice(15.5);

        TEST_POT = new Pot();
        TEST_POT.setName("Pot Name");
        TEST_POT.setVolume(5);
        TEST_POT.setMaterial(TEST_MATERIAL);
        TEST_POT.setArticle(TEST_ARTICLE);
    }


    @Test
    void stock() {
        materialRepository.save(TEST_MATERIAL);
        articleRepository.save(TEST_ARTICLE);
        potRepository.save(TEST_POT);

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
