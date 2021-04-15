package com.example.demo;

public class TodoModel {
    private long id;
    private String name;

    public TodoModel(){
        // Default constructor
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TodoModel(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
