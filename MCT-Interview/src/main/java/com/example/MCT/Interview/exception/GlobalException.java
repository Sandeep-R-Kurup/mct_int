package com.example.MCT.Interview.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(FoundNothing.class)
    public String giveException(FoundNothing foundNothing){
        String message = foundNothing.getMessage();
        return message;
    }
}
