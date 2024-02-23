package com.example.plantbusiness.services.web;

import com.example.plantbusiness.model.dto.CreatedMaterialDto;
import com.example.plantbusiness.model.dto.MaterialDto;
import com.example.plantbusiness.model.entity.Material;
import com.example.plantbusiness.services.app.MaterialAppServiceImpl;
import com.example.plantbusiness.services.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialWebService {
    @Autowired
    MaterialAppServiceImpl appService;

    @Autowired
    MaterialMapper mapper;

    public List<CreatedMaterialDto> getAll() {
        return appService.getAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public CreatedMaterialDto getById(Long id) {
        return mapper.toDto(
                appService.getById(id));
    }

    public CreatedMaterialDto create(MaterialDto material) {
        return  mapper.toDto(
                appService.create(
                        mapper.toEntity(material)
                )
        );
    }

    public CreatedMaterialDto update(MaterialDto materialDto) {
        return mapper.toDto(
                appService.update(
                        mapper.toEntity(materialDto)
                )
        );
    }

    public void delete(Long id){
        appService.delete(id);
    }
}
