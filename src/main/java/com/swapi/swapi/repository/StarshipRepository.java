package com.swapi.swapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.swapi.swapi.model.Starships;

public interface StarshipRepository extends CrudRepository<Starships, Long>{
    
}
