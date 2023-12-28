package com.swapi.swapi.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class Starships {
    @Setter(AccessLevel.NONE)
    @Id
     @GeneratedValue
    private Long id;
    private Integer mglt;
    private String starshipClass;
    private double hyperdriveRate;

        @ManyToMany
@JoinTable(
  
  name = "starships_people", 
  joinColumns = @JoinColumn(name = "starship_id"), 
  inverseJoinColumns = @JoinColumn(name = "people_id"))
Set<People> pilots;



    
}
