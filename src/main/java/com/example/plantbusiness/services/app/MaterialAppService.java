package com.example.plantbusiness.services.app;

import com.example.plantbusiness.model.entity.Material;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MaterialAppService {
    public List<Material> getAll();

    public Material getById(Long id);
}
