package com.swapi.swapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.swapi.swapi.model.Planets;

public interface PlanetsRepository extends CrudRepository<Planets, Long> {
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Planets p WHERE p.name = :name")
    boolean existsByName(@Param("name") String name);

}
