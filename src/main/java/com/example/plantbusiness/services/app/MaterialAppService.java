package com.example.plantbusiness.services.app;

import com.example.plantbusiness.model.Material;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MaterialAppService {
    List<Material> getAll();

    Material getById(Long id);
}
