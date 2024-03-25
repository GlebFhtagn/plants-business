package com.example.plantbusiness;

import com.example.plantbusiness.model.Material;
import com.example.plantbusiness.model.PlantSpecies;
import com.example.plantbusiness.model.articles.Article;
import com.example.plantbusiness.model.articles.Pot;
import com.example.plantbusiness.model.articles.Seed;
import com.example.plantbusiness.model.storage.WarehouseRecord;
import com.example.plantbusiness.repositories.WarehouseRecordRepository;
import com.example.plantbusiness.services.WarehouseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class WarehouseTest {

    @Autowired
    WarehouseService warehouse;

    @Autowired
    WarehouseRecordRepository wrRepository;

    @Autowired
    CommonDBMethods dbMethods;

    static Material TEST_MATERIAL = new Material("Plastic");
    static PlantSpecies TEST_SPECIES = new PlantSpecies("Rose");
    static Pot TEST_POT = Pot.potBuilder()
            .name("Pot for warehouse stock [test]")
            .description("This is test pot, not for sale")
            .barcode(14352345L)
            .price(1000)
            .material(TEST_MATERIAL)
            .volume(18888L)
            .build();
    static Seed TEST_SEED = Seed.seedBuilder()
            .name("Seed for warehouse stock [test]")
            .description("This is test seeds, not for sale")
            .barcode(14352345L)
            .price(1000)
            .weight(50L)
            .species(TEST_SPECIES)
            .build();


    @Test
    public void StockWHGetItemFromWH_noErrors(){
        dbMethods.batchSave(TEST_MATERIAL, TEST_SPECIES, TEST_POT, TEST_SEED);


        Map<Article, Long> delivery = new HashMap<>();
        delivery.put(TEST_POT, 15L);
        delivery.put(TEST_SEED, 1L);

        //Stock Warehouse with 2 items
        warehouse.stockWarehouse(delivery);

        List<WarehouseRecord> savedStock = wrRepository.findAll();

        WarehouseRecord warehouseRecord = savedStock.stream()
                .filter(x -> x.getArticle().equals(TEST_POT))
                .findAny().orElse(null);
        assert warehouseRecord != null;
        Assertions.assertEquals(TEST_POT, warehouseRecord.getArticle());
        WarehouseRecord warehouseRecord1 = savedStock.stream()
                .filter(x -> x.getArticle().equals(TEST_SEED))
                .findAny().orElse(null);
        assert warehouseRecord1 != null;
        Assertions.assertEquals(TEST_SEED, warehouseRecord1.getArticle());

        //Get Needed 10 Articles from Warehouse
        Map.Entry<Article, Long> record = warehouse.getItemFromStock(TEST_POT, 10L);

        Assertions.assertEquals(TEST_POT, record.getKey());
        Assertions.assertEquals(10L, record.getValue());

        //5 Articles left in Warehouse
        WarehouseRecord leftArticles = wrRepository.findByArticle(TEST_POT);
        Assertions.assertEquals(5L, leftArticles.getQuantity());

    }

}
