package com.swapi.swapi.web;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.swapi.swapi.error.ObjectExistsException;
import com.swapi.swapi.mapper.FilmsMapper;
import com.swapi.swapi.model.Films;
import com.swapi.swapi.model.People;
import com.swapi.swapi.model.Films.FilmsBuilder;
import com.swapi.swapi.repository.FilmsRepository;
import com.swapi.swapi.repository.PeopleRepository;
import com.swapi.swapi.repository.PlanetsRepository;
import com.swapi.swapi.repository.StarshipRepository;
import com.swapi.swapi.repository.VehiclesRepository;
import com.swapi.swapi.service.ObjectValidator;
import com.swapi.swapi.web.dto.CreateFilm;
import com.swapi.swapi.web.dto.FilmsCharacters;
import com.swapi.swapi.web.dto.UpdatePersonCharacters;

import jakarta.persistence.EntityNotFoundException;

import com.swapi.swapi.web.dto.FilmsCharacters.FilmsCharactersBuilder;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
public class FilmsController {
  @Autowired
  FilmsRepository filmsRepository;
  @Autowired
  PeopleRepository peopleRepository;
  @Autowired
  PlanetsRepository planetsRepository;
  @Autowired
  ObjectValidator objectValidator;
  @Autowired
  VehiclesRepository vehiclesRepository;
  @Autowired
  StarshipRepository starshipRepository;
  @Autowired
  FilmsMapper filmsMapper;

  @PostMapping("/films")
  public CreateFilm Name(@RequestBody CreateFilm createFilm) {


    objectValidator.validate(createFilm);
    if (filmsRepository.existsByTitle(createFilm.getTitle())) {
      throw new ObjectExistsException();

    }

    Films inListFilm = Films.builder().title(createFilm.getTitle())
        .producer(createFilm.getProducer()).epsiodeId(createFilm.getEpsiodeId())
        .director(createFilm.getDirector()).openingCrawl(createFilm.getOpeningCrawl())
        .releasDate(createFilm.getReleasDate()).build();
    Set<People> people = inListFilm.getCharacters();
    List<Long> charactersId = new ArrayList<>();
    for (People person : people) {

      charactersId.add(person.getId());

    }
    filmsRepository.save(inListFilm);
    CreateFilm createFilmResult =
        CreateFilm.builder().title(inListFilm.getTitle()).epsiodeId(createFilm.getEpsiodeId())
            .openingCrawl(inListFilm.getOpeningCrawl()).characters(charactersId).build();
    return createFilmResult;



  }

  @PostMapping("/films/{id}/characters")
  public FilmsCharacters postMethodName(@PathVariable Long id,
      @RequestBody UpdatePersonCharacters entity) {

    Films films = filmsRepository.findById(id).get();
    Films updatedFilms = filmsRepository.save(films);
    Set<People> findAll = updatedFilms.getCharacters();
    List<Long> peronstoReturn = new ArrayList<>();

    for (People people : findAll) {
      Long elementInList = people.getId();
      peronstoReturn.add(elementInList);
    }
    FilmsCharacters filmsCharacters = FilmsCharacters.builder().characters(peronstoReturn).build();
    return filmsCharacters;

  }

}
