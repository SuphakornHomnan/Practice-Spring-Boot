package com.example.demo.Todo;

public class TodoNotFoundException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public TodoNotFoundException(){

    }
    public TodoNotFoundException(long id){
        super("Could not find todo " + id);
    }
}
