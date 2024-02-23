package com.example.plantbusiness.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MaterialDto {

    @NotNull
    @NotBlank
    String name;

}
