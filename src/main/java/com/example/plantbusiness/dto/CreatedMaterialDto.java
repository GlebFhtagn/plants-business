package com.example.plantbusiness.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.annotation.Nonnull;
import lombok.Builder;
import lombok.Getter;

@Builder @Getter
public class CreatedMaterialDto {

    @Nonnull
    Long id;

    @Nonnull
//    @JsonUnwrapped
    MaterialDto value;
}
