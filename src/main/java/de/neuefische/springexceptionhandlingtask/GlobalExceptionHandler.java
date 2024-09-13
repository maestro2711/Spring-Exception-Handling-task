package de.neuefische.springexceptionhandlingtask;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)

    public ErrorMessage handleIllegalArgumentException(RuntimeException e){
        System.out.println("IllegalArgumentException:" +e.getMessage());
        return new ErrorMessage(e.getMessage(), Instant.now());
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleExcption(Exception e){
        System.out.println("EXCEPTION: " +e.getMessage());
        return new ErrorMessage(e.getMessage(),Instant.now());
    }
}
