package com.swapi.swapi.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidEpisodIdConstraint implements ConstraintValidator<EpisodeId,Integer> {

    @Override
    public boolean isValid(Integer episodeId, ConstraintValidatorContext context) {
        // TODO Auto-generated method stub
        if(episodeId<1||episodeId>10||episodeId==null){
            return false;
        }
        return true;
    }

}
