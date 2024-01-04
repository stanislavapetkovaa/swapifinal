package com.swapi.swapi.web;

import org.springframework.web.bind.annotation.RestController;
import com.swapi.swapi.error.ObjectExistsException;
import com.swapi.swapi.model.Planets;
import com.swapi.swapi.repository.PlanetsRepository;
import com.swapi.swapi.web.dto.CreatePlanet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public Planets postMethodName(@RequestBody CreatePlanet createPlanet) {
        // TODO: process POST request
        if (planetsRepository.existsByName(createPlanet.getName())) {
            throw new ObjectExistsException();
        }


        Planets planet = Planets.builder().climate(createPlanet.getClimate())
                .gravity(createPlanet.getGravity()).name(createPlanet.getName())
                .population(createPlanet.getPopulation()).terrain(createPlanet.getTerrain())
                .surfaceWater(createPlanet.getSurfaceWater())
                .orbitalPeriod(createPlanet.getOrbitalPeriod())
                .rotationPeriod(createPlanet.getRotationPeriod()).edited(createPlanet.getEdited())
                .created(createPlanet.getCreated()).build();

        return planetsRepository.save(planet);
    }

    @GetMapping("/planets/{planetId}")
    public Planets getPlanets(@PathVariable Long planetId) {
        return planetsRepository.findById(planetId).get();

    }

    @DeleteMapping("/planets/{id}")
    public void deletePlanet(@PathVariable Long id) {
        Planets planet = planetsRepository.findById(id).get();
        planetsRepository.delete(planet);

    }



}
