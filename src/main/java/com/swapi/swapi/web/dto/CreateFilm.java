package com.swapi.swapi.web.dto;

import java.time.LocalDate;
import java.util.List;

import com.swapi.swapi.validation.EpisodeId;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateFilm {
    @NotBlank
    private String title;
    private String openingCrawl;
    private String producer;
    private String director;
    @EpisodeId
    private Integer epsiodeId;
    private LocalDate releasDate;
    private LocalDate edited;
    private LocalDate created;
    List<Long> characters;
    List<Long> planets;
    List<Long> vehicles;
    List<Long> starships;

    
}
