package com.example.plantbusiness.services.app;

import com.example.plantbusiness.model.entity.Material;
import com.example.plantbusiness.repositories.MaterialRepository;
import com.example.plantbusiness.services.merger.MaterialMerger;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MaterialAppServiceImpl implements MaterialAppService{

    @Autowired
    MaterialRepository repository;

    @Autowired
    MaterialMerger merger;

    @Override
    public List<Material> getAll(){
        return repository.findAll();
    }

    @Override
    public Material getById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Material create(Material material) {
        return repository.save(material);
    }

    public Material update(Material material) {
        Material persistedMaterial = repository.findById(material.getId()).orElseThrow(EntityNotFoundException::new);
        persistedMaterial = merger.merge(persistedMaterial, material);
        repository.save(persistedMaterial);
        return persistedMaterial;
    }

    public void delete(Long id){
        Material persistedMaterial = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.delete(persistedMaterial);
    }
}
