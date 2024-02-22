package com.example.plantbusiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.example.plantbusiness.*")
//@EntityScan(basePackages = {"com.example.plantbusiness.model.entity"})
public class PlantBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlantBusinessApplication.class, args);
    }

}
