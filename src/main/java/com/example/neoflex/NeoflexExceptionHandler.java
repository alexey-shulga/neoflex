package com.example.neoflex;

import com.example.neoflex.exceptions.InvalidInputException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class NeoflexExceptionHandler {

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<String> handle(InvalidInputException exc) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
    }

}
