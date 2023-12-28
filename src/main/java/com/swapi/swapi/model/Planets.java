package com.swapi.swapi.model;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Planets {
   
    @Id
    @GeneratedValue
    private Long id;
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
     @JsonIgnore
     @OneToMany(mappedBy = "homeworld", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<People> residents;


}
