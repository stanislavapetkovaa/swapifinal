package com.swapi.swapi.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.swapi.swapi.model.People;
import com.swapi.swapi.model.Planets;

public interface PeopleRepository extends CrudRepository<People, Long> {

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM People p WHERE p.name = :name")
    boolean existsByName(@Param("name") String name);

}
