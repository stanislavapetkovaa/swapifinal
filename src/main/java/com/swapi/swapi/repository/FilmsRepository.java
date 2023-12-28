package com.swapi.swapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swapi.swapi.model.Films;

@Repository
public interface FilmsRepository extends CrudRepository<Films,Long> {
    
}
