package com.swapi.swapi.web.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CreatePeople {
    @NotBlank
    private String name;
    private String gender;
    private String hairColor;
    private String eyeColor;
    @Min(value = 0, message = "Mass must be greater than or equal to 0")
    private Integer mass;
    @Min(value = 0, message = "Height must be greater than or equal to 0")
    private Integer height;
    private String birthYear;
    private LocalDate edited;
    private LocalDate created;
    private Long homeworld;
    
}
