package com.Tobeto.RentaCar.core.utilites.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<String> handleValidationException(MethodArgumentNotValidException exception) {
        List<String> errors = new ArrayList<>();

        for (FieldError error: exception.getBindingResult().getFieldErrors()) {
            errors.add(error.getDefaultMessage());
        }
        return  errors;

    }
    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleRuntimeError(RuntimeException exception){
        return exception.getMessage();
    }

//    @ExceptionHandler({Exception.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public String handleUnkownErrors(){
//        return "Bilinmedik hata";
//    }

}
