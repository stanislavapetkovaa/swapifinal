package com.swapi.swapi.validation;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ValidEpisodIdConstraint.class)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EpisodeId {
    String message() default "Episod id must be between 1 and 9";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
