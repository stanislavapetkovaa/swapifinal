package com.swapi.swapi.web.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateStarshipRequest {
    private Integer mglt;
    @NotBlank
    private String starshipClass;
    private double hyperdriveRate;
    List<Long> pilots;
    
}
