package com.example.demo.Todo;

public class TodoUnauthorizeException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public TodoUnauthorizeException(){
        super("Token Invaild");
    }
}
