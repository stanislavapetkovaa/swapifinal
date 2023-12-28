package com.swapi.swapi.web.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePlanet {

    @NotBlank 
    private String name;
    private String climate;
    private Long surfaceWater;
    private Long rotationPeriod;
    private Long population;
    private Long orbitalPeriod;
    private String gravity;
    private String terrain;
    private LocalDate edited;
    private LocalDate created;
    
}
