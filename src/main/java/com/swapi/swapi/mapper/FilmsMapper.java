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
import com.swapi.swapi.web.dto.CreatePeople;
import com.swapi.swapi.web.dto.FilmsCharacters;
import com.swapi.swapi.web.dto.UpdatePersonCharacters;

@Mapper
public abstract class FilmsMapper {

    @Mapping(source = "characters", target = "characters", qualifiedByName = "mapCharacters", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract  Films updatePersonFromUpdateRequest(UpdatePersonCharacters req, @MappingTarget Films films);
    @Named(value = "mapCharacters")
    public Set<People> mapCharacters(List<Long> characters){
        
        
        if(characters.isEmpty()||characters==null){
            return null;

        }
        Set<People> people = new HashSet<>();
        
        for(Long characterId : characters){
            People person = new People();
            person.setId(characterId);
            people.add(person);

        }
        return people;
    }


    

    
}
