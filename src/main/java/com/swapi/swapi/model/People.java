package com.swapi.swapi.model;

import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Data
@Table(name = "people", uniqueConstraints = @UniqueConstraint(columnNames = {"id", "name"}))
@NoArgsConstructor
@AllArgsConstructor
public class People {
    // @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)

    private String name;
    private String gender;
    private String hairColor;
    private String eyeColor;
    private Integer mass;
    private Integer height;
    private String birthYear;
    private LocalDate edited;
    private LocalDate created;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "planet_id", referencedColumnName = "id")
    private Planets homeworld;



}
