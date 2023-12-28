package com.swapi.swapi.web;

import java.util.Map;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.swapi.swapi.error.ObjectNotFound;

import lombok.Builder;
import lombok.Data;

import com.swapi.swapi.error.AuthenticationFailedException;
import com.swapi.swapi.error.InvalidObjectException;



@RestControllerAdvice
public class ExceptionHandlerAdvice {


    // handle entity not found
    @ExceptionHandler(ObjectNotFound.class)
    public ResponseEntity<SwapiHttpHttpException> entityNotFound(ObjectNotFound ex) {
        SwapiHttpHttpException httpEx = SwapiHttpHttpException.builder().errorId(ex.getId())
                .message(ex.getMessage() + ". Not found ID: " + ex.getEntityId())
                .clazz(ex.getEntityClass()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(httpEx);
    }



    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<SwapiHttpHttpException> methodNotAllowed(
            HttpRequestMethodNotSupportedException ex) {
        SwapiHttpHttpException httpEx = SwapiHttpHttpException.builder().errorId(UUID.randomUUID())
                .message("Method not allowed: " + ex.getMethod()).build();
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(httpEx);
    }

    @ExceptionHandler(InvalidObjectException.class)
    public ResponseEntity<SwapiHttpHttpException> invalidObject(InvalidObjectException e) {
        SwapiHttpHttpException httpEx = SwapiHttpHttpException.builder().errorId(e.getId())
                .message(e.getMessage()).errors(e.getConstraintViolations()).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(httpEx);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<SwapiHttpHttpException> illegalArgument(IllegalArgumentException e) {
        SwapiHttpHttpException httpEx = SwapiHttpHttpException.builder().errorId(UUID.randomUUID())
                .message(e.getMessage()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(httpEx);
    }
        @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<SwapiHttpHttpException> authenticationFailed(
            AuthenticationFailedException e) {
        SwapiHttpHttpException httpEx = SwapiHttpHttpException.builder().errorId(e.getId())
                .message(e.getMessage() + ". Cause: " + e.getConcreteError()).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(httpEx);
    }

    @Data
    @Builder
    private static class SwapiHttpHttpException {
        private UUID errorId;
        private String message;
        private String clazz;
        private Map<String, String> errors;
    }

}
