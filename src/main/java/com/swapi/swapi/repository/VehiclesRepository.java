package com.swapi.swapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.swapi.swapi.model.Vehicles;

public interface VehiclesRepository extends CrudRepository<Vehicles,Long>{
    
}
