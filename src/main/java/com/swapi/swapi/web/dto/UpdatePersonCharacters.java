package com.swapi.swapi.web.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdatePersonCharacters {
    Long filmId;
    List<Long> characters;
    
    
}
