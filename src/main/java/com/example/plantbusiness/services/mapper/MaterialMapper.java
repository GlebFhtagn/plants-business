package com.example.plantbusiness.services.mapper;

import com.example.plantbusiness.dto.CreatedMaterialDto;
import com.example.plantbusiness.dto.MaterialDto;
import com.example.plantbusiness.model.entity.Material;
import org.springframework.stereotype.Component;

@Component
public class MaterialMapper {
    public CreatedMaterialDto toDto(Material material) {
        return CreatedMaterialDto.builder()
                .id(material.getId())
                .value(new MaterialDto(material.getName()))
                .build();
    }

    public Material toEntity(MaterialDto dto){
        return new Material(dto.getName());
    }
}
