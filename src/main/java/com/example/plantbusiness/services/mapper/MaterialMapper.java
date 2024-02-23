package com.example.plantbusiness.services.mapper;

import com.example.plantbusiness.model.dto.CreatedMaterialDto;
import com.example.plantbusiness.model.dto.MaterialDto;
import com.example.plantbusiness.model.entity.Material;
import org.springframework.stereotype.Component;

@Component
public class MaterialMapper {
    public CreatedMaterialDto toDto(Material material) {
        return CreatedMaterialDto.builder()
                .id(material.getId())
                .value(MaterialDto.builder()
                        .name(material.getName())
                        .build())
                .build();
    }

    public Material toEntity(MaterialDto dto){
        return Material.builder()
                .name(dto.getName())
                .build();
    }
}
