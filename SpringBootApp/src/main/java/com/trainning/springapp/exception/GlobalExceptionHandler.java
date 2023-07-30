package com.trainning.springapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorObject> HandlePostNotFoundException(EntityNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorObject(HttpStatus.NOT_FOUND, new Date(), ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}