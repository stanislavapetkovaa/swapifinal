package com.swapi.swapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.swapi.swapi.model.Planets;

public interface PlanetsRepository extends CrudRepository<Planets,Long>{
    
}
