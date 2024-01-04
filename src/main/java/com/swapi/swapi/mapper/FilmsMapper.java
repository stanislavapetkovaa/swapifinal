package com.swapi.swapi.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.swapi.swapi.model.Films;
import com.swapi.swapi.model.People;
import com.swapi.swapi.web.dto.CreateFilm;
import com.swapi.swapi.web.dto.CreatePeople;
import com.swapi.swapi.web.dto.FilmsCharacters;
import com.swapi.swapi.web.dto.UpdatePersonCharacters;

@Mapper
public abstract class FilmsMapper {

    @Mapping(target = "title",
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "openingCrawl",
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "producer",
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "characters", ignore = true)
    @Mapping(target = "planets", ignore = true)
    @Mapping(target = "starships", ignore = true)
    @Mapping(target = "vehicles", ignore = true)
    public abstract Films updateFilms(CreateFilm req, @MappingTarget Films films);



}
