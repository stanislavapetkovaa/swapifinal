package com.swapi.swapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.swapi.swapi.model.People;
import com.swapi.swapi.model.Planets;
import com.swapi.swapi.web.dto.CreatePeople;

@Mapper
public abstract class PeopleMapper {

    @Mapping(target = "name",
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "gender",
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "homeworld", target = "homeworld", qualifiedByName = "mapHomeworld",
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract People updatePersonFromUpdateRequest(CreatePeople req,
            @MappingTarget People person);

    @Named("mapHomeworld")
    protected Planets mapHomeworld(Long homeworldId) {

        if (homeworldId != 0) {
            Planets planets = new Planets();
            planets.setId(homeworldId);
            // Additional mapping logic if needed
            return planets;
        }
        return null;

    }


}


