package com.example.prueba2_spring_boot.exception;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest rq) {
        return new ResponseEntity<>(ExceptionResponse.builder()
                .error("Entity Not found")
                .message(ex.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    private ResponseEntity<Object> handleDuplicateKeyException(DuplicateKeyException ex, WebRequest rq) {
        return new ResponseEntity<>(ExceptionResponse.builder()
                .error("Duplicate key exception")
                .message(ex.getMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }
}
