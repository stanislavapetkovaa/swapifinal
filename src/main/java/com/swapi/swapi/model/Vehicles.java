package com.swapi.swapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import java.util.Set;


@Entity
@Data
@Builder
public class Vehicles {
  @Setter(AccessLevel.NONE)
  @Id
  @GeneratedValue
  private Long id;
  @Column(unique = true)
  private String vehicleClass;

  @ManyToMany
  @JoinTable(name = "vehicles_people", joinColumns = @JoinColumn(name = "vehicles_id"),
      inverseJoinColumns = @JoinColumn(name = "people_id"))
  Set<People> pilots;


}
