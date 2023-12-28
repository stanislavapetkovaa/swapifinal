package com.swapi.swapi.web;

import org.springframework.web.bind.annotation.RestController;

import com.swapi.swapi.model.Planets;
import com.swapi.swapi.repository.PlanetsRepository;
import com.swapi.swapi.web.dto.CreatePlanet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class PlanetController {

    @Autowired
    PlanetsRepository planetsRepository;

    @GetMapping("/planets")
    public List<Planets> getAllPlanets() {
        List<Planets> planets = (List<Planets>) planetsRepository.findAll();
        return planets;
    }

    @PostMapping("/planets")
    public List<Planets> postMethodName(@RequestBody List<CreatePlanet> createPlanets) {
        //TODO: process POST request

        List<Planets> planets = new ArrayList<>();
        for(CreatePlanet createPlanet : createPlanets)
        {
        Planets planet = Planets.builder()
        .climate(createPlanet.getClimate()).gravity(createPlanet.getGravity()).
        name(createPlanet.getName()).population(createPlanet.getPopulation()).terrain(createPlanet.getTerrain()).
        surfaceWater(createPlanet.getSurfaceWater()).orbitalPeriod(createPlanet.getOrbitalPeriod()).
        rotationPeriod(createPlanet.getRotationPeriod()).
        edited(createPlanet.getEdited()).created(createPlanet.getCreated()).build();
        planets.add(planet);
        }
        return  (List<Planets>) planetsRepository.saveAll(planets);
    }

    @GetMapping("/planets/{planetId}")
    public Planets getPlanets(@PathVariable Long planetId) {
        return  planetsRepository.findById(planetId).get();
        
    }
    
    
    
    
}
