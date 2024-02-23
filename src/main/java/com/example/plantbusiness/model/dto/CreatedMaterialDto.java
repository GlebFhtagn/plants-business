package com.example.plantbusiness.model.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.annotation.Nonnull;
import lombok.Builder;

@Builder
public class CreatedMaterialDto {

    @Nonnull
    Long id;

    @Nonnull
    @JsonUnwrapped
    MaterialDto value;
}
