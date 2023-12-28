package com.swapi.swapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.swapi.swapi.model.People;
import com.swapi.swapi.model.Planets;

public interface PeopleRepository extends CrudRepository<People,Long>{
    
}
