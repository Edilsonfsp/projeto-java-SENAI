package com.edilson.projeto.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.edilson.projeto.services.exceptions.ObjectNotFoundException;
import com.edilson.projeto.services.exceptions.StandardError;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandleResource {
    
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    
}
