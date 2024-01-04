package com.swapi.swapi.model;

import java.time.LocalDate;
import java.util.Set;
import jakarta.persistence.Column;
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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Films {
  @Setter(AccessLevel.NONE)
  @Id
  @GeneratedValue
  private Long id;
  @Column(unique = true)
  private String title;
  private String openingCrawl;
  private String producer;
  private String director;
  private Integer epsiodeId;
  private LocalDate releasDate;
  private LocalDate edited;
  private LocalDate created;

  @ManyToMany
  @JoinTable(

      name = "films_people", joinColumns = @JoinColumn(name = "film_id"),
      inverseJoinColumns = @JoinColumn(name = "people_id"))
  Set<People> characters;


  @ManyToMany
  @JoinTable(

      name = "films_planets", joinColumns = @JoinColumn(name = "film_id"),
      inverseJoinColumns = @JoinColumn(name = "planet_id"))
  Set<Planets> planets;

  @ManyToMany
  @JoinTable(

      name = "films_vehicles", joinColumns = @JoinColumn(name = "film_id"),
      inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
  Set<Vehicles> vehicles;

  @ManyToMany
  @JoinTable(

      name = "films_starhips", joinColumns = @JoinColumn(name = "film_id"),
      inverseJoinColumns = @JoinColumn(name = "starhips_id"))
  Set<Starships> starships;



}
