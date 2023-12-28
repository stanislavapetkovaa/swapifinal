package com.swapi.swapi.web;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.swapi.swapi.model.People;
import com.swapi.swapi.model.Starships;
import com.swapi.swapi.repository.PeopleRepository;
import com.swapi.swapi.repository.StarshipRepository;
import com.swapi.swapi.web.dto.CreateStarshipRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class StarshipsController {
    @Autowired
    StarshipRepository starshipRepository;
    @Autowired
    PeopleRepository peopleRepository;

    @PostMapping("/starships")
    public Starships createStarships(@RequestBody CreateStarshipRequest createStarshipRequest) {
       List<Long> pilotIds = createStarshipRequest.getPilots();
       Set<People> people = new HashSet<>();
       for(Long i:pilotIds){
        People person = peopleRepository.findById(i).get();
        people.add(person);

       }

        Starships starships = Starships.builder()
        .mglt(createStarshipRequest.getMglt())
        .hyperdriveRate(createStarshipRequest.getHyperdriveRate())
        .starshipClass(createStarshipRequest.getStarshipClass())
        .pilots(people)
        .build();
        return starshipRepository.save(starships);





        
       
    }

    @GetMapping("/starships")
    public List<CreateStarshipRequest> geStarships() {
        List<CreateStarshipRequest> resultStarships = new ArrayList<>();
        List<Starships> starships = (List<Starships>) starshipRepository.findAll();

        for(Starships starship: starships){
            CreateStarshipRequest createStarshipRequest = new CreateStarshipRequest();
            List<Long> pilotIds = new ArrayList<>();
            Set<People> people = starship.getPilots();
            for(People person:people){

                pilotIds.add(person.getId());
            }
            createStarshipRequest = CreateStarshipRequest.builder()
            .mglt(starship.getMglt())
            .starshipClass(starship.getStarshipClass())
            .pilots(pilotIds)
            .build();
            resultStarships.add(createStarshipRequest);

        }
        return resultStarships;
        
    }
    
    
    
}
