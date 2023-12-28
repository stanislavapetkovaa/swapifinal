package com.swapi.swapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.swapi.swapi.model.Transport;

public interface TransportRepository extends CrudRepository<Transport,Long>{
    
}
