package com.example.plantbusiness.services.merger;

import com.example.plantbusiness.model.entity.Material;
import org.springframework.stereotype.Component;

@Component
public class MaterialMerger {
    public Material merge(Material persistedMaterial, Material material) {
        persistedMaterial.setName(material.getName());
        return persistedMaterial;
    }
}
