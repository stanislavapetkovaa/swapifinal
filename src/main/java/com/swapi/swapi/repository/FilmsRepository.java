package com.swapi.swapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swapi.swapi.model.Films;

@Repository
public interface FilmsRepository extends CrudRepository<Films, Long> {
    @Query("SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END FROM  Films f WHERE f.title = :name")
    boolean existsByTitle(@Param("name") String name);

}
