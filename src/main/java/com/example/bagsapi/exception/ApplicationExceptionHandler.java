package com.example.bagsapi.exception;


import com.example.bagsapi.exception.validation.ValidationError;
import com.example.bagsapi.exception.validation.ValidationErrorCreator;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler(value = {BagNotFoundException.class, TicketNotFoundException.class, UserNotFoundException.class})
    private ResponseEntity<Object> handleResourceNotFoundException(RuntimeException exception, WebRequest webRequest) {
        Map<String, Object> body = new LinkedHashMap<>(); //Keeping insertion order
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());

        if(exception instanceof BagNotFoundException)
            body.put("message","Bag with ID: " +  ((BagNotFoundException) exception).getId() + " was not found");

        else if(exception instanceof TicketNotFoundException)
            body.put("message","Ticket with ID: " +  ((TicketNotFoundException) exception).getId() + " was not found");

        else if(exception instanceof UserNotFoundException)
            body.put("message","User with ID: " +  ((UserNotFoundException) exception).getId() + " was not found");


        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());

        ValidationError errors = ValidationErrorCreator.createValidationError(ex.getBindingResult());
        body.put("message", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }


}
