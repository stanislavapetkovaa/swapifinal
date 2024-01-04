package com.swapi.swapi.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
@Entity
public class Transport {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;
    private String manufacturer;
    private String consumables;
    private String crew;
    private String model;
    private Integer passengers;
    private Integer maxAtmospheringSpeed;
    private Integer cargoCapacity;
    private Integer costInCredits;
    private LocalDate created;
    private LocalDate edited;


}
