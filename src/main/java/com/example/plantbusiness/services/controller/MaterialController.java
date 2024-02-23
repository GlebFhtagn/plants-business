package com.example.plantbusiness.services.controller;

import com.example.plantbusiness.model.dto.CreatedMaterialDto;
import com.example.plantbusiness.model.dto.MaterialDto;
import com.example.plantbusiness.model.entity.Material;
import com.example.plantbusiness.services.web.MaterialWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/material")
@Service
public class MaterialController {

    @Autowired
    MaterialWebService webService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<CreatedMaterialDto> getAll(){
        return webService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CreatedMaterialDto getById(@PathVariable Long id){
        return webService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CreatedMaterialDto create(@RequestBody MaterialDto materialDto){
        return webService.create(materialDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    CreatedMaterialDto update(@RequestBody MaterialDto materialDto){
        return webService.update(materialDto);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable Long id){
        webService.delete(id);
    }
}
