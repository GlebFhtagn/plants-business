package com.example.plantbusiness.controller;

import com.example.plantbusiness.dto.CreatedMaterialDto;
import com.example.plantbusiness.dto.MaterialDto;
import com.example.plantbusiness.services.web.MaterialWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("material")
public class MaterialController implements SQLExceptionHandler {

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

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    CreatedMaterialDto create(@RequestBody  MaterialDto materialDto){
        return webService.create(materialDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CreatedMaterialDto update(@RequestBody MaterialDto materialDto, @PathVariable Long id){
        return webService.update(id, materialDto);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable Long id){
        webService.delete(id);
    }
}
