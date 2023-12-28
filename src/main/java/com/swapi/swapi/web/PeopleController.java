package com.swapi.swapi.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.swapi.swapi.mapper.PeopleMapper;
import com.swapi.swapi.model.People;
import com.swapi.swapi.model.Planets;
import com.swapi.swapi.repository.PeopleRepository;
import com.swapi.swapi.repository.PlanetsRepository;
import com.swapi.swapi.web.dto.CreatePeople;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class PeopleController {
    @Autowired
    PeopleRepository peopleRepository;
    @Autowired
    PlanetsRepository planetsRepository;
    @Autowired
    PeopleMapper personmapper;


    @GetMapping("/people")
    public Set<CreatePeople> allPeople () {
        Iterable<People> peopleIterable=  peopleRepository.findAll();
        
        Set<CreatePeople> peopleC = new HashSet<>();

        for(People person:peopleIterable){
            Long homeworldId = person.getHomeworld().getId(); // Assuming homeworldId is the ID of the planet
        //Planets homeworld = planetsRepository.findById(homeworldId).orElse(null);
            CreatePeople createPeople = CreatePeople.builder().
            name(person.getName()).birthYear(person.getBirthYear())
            .height(person.getHeight()).homeworld(homeworldId).
            mass(person.getMass()).eyeColor(person.getEyeColor()).build();
            peopleC.add(createPeople);

        }
        
        return peopleC;
    }

    @PostMapping("/people")
    public Set<People> addPeople(@RequestBody Set<CreatePeople> createPeoples) {
        Set<People> people=new HashSet<>();
    
        for (CreatePeople createPeople : createPeoples) {
            Optional<Planets> homeworld = planetsRepository.findById(createPeople.getHomeworld());
            // Assuming findByName is a method in PlanetsRepository to find a planet by name
    
            People person = People.builder()
                    .name(createPeople.getName())
                    .birthYear(createPeople.getBirthYear())
                    .gender(createPeople.getGender())
                    .hairColor(createPeople.getHairColor())
                    .height(createPeople.getHeight())
                    .eyeColor(createPeople.getEyeColor())
                    .homeworld(homeworld.get())
                    .hairColor(createPeople.getBirthYear())
                    .birthYear(createPeople.getBirthYear())
                    .mass(createPeople.getMass())
                    .edited(createPeople.getEdited())
                    .created(createPeople.getCreated())
                    .build();
    
            people.add(person);
        }
    
        Iterable<People> savedPeople = peopleRepository.saveAll(people);
        return new HashSet<>((Collection<? extends People>) savedPeople);
    }

    @GetMapping("/people/{id}")
    public CreatePeople createPeople(@PathVariable Long id) {
        People people = peopleRepository.findById(id).get();
        CreatePeople createPeople = CreatePeople.builder()
        .name(people.getName())
        .birthYear(people.getBirthYear())
        .homeworld(people.getHomeworld().getId())
        .gender(people.getGender())
        .mass(people.getMass())
        .build();
        return createPeople;
    }

    @PutMapping("/people/{id}")
    public People updatePeople(@PathVariable Long id, @RequestBody CreatePeople createPeople) {
        
        People people = peopleRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException(People.class.getName()));

      personmapper.updatePersonFromUpdateRequest(createPeople, people);
        
        return peopleRepository.save(people);
    }

    
    
    
}
    

