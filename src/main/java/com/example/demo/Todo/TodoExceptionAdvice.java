package com.example.demo.Todo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TodoExceptionAdvice {
    public TodoExceptionAdvice() {

    }

    @ResponseBody
    @ExceptionHandler(TodoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String todoNotFound(TodoNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(TodoUnauthorizeException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    String todoUnauthorize(TodoUnauthorizeException ex){
        return ex.getMessage();
    }
}
