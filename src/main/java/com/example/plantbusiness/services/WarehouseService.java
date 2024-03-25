package com.example.plantbusiness.services;

import com.example.plantbusiness.model.articles.Article;
import com.example.plantbusiness.model.storage.WarehouseRecord;
import com.example.plantbusiness.repositories.WarehouseRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRecordRepository repository;

    public void stockWarehouse(Map<Article, Long> arrivedSupply){
        List<WarehouseRecord> currentStock = repository.findAll();
        List<WarehouseRecord> updatedStock = new ArrayList<>();
        arrivedSupply.entrySet().forEach(es -> {
            WarehouseRecord stockItem = currentStock.stream()
                    .filter(wr -> wr.getArticle().getName().equals( es.getKey().getName() ))
                    .findAny()
                    .orElse(null);
            if(stockItem == null){
                stockItem = formNewRecord(es.getKey(), es.getValue());
            }
            else {
                Long quantityAfterStock = stockItem.getQuantity() + es.getValue();
                stockItem.setQuantity(quantityAfterStock);
            }
            updatedStock.add(stockItem);
        });

        repository.saveAll(updatedStock);
    }

    public Map<Article, Long> productAccounting(){
        List<WarehouseRecord> currentStock = repository.findAll();

        return currentStock.stream().collect(Collectors.toMap(WarehouseRecord::getArticle, WarehouseRecord::getQuantity));
    }

    public Map.Entry<Article, Long> getItemFromStock(Article article, Long quantity){
        WarehouseRecord persistedRecord = repository.findByArticle(article);
        Long persistedQuantity = persistedRecord.getQuantity();
        Long returnQuantity;
        if(quantity >= persistedQuantity){
            persistedRecord.setQuantity(0L);
            returnQuantity = persistedQuantity;
        }
        else {
            Long newQuantity = persistedRecord.getQuantity() - quantity;
            persistedRecord.setQuantity(newQuantity);
            returnQuantity = quantity;
        }
        repository.save(persistedRecord);
        return Map.entry(article, returnQuantity);
    }


    private WarehouseRecord formNewRecord(Article article, Long quantity){
        WarehouseRecord newWarehouseRecord = new WarehouseRecord(article, quantity);
        return  newWarehouseRecord;
    }
}
