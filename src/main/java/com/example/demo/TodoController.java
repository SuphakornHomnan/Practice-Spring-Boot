package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    private List<TodoModel> todos = new ArrayList<>();

    public TodoController() {
        todos.add(new TodoModel(1, "todoTODO"));
        todos.add(new TodoModel(2, "todoTODO2"));
        todos.add(new TodoModel(3, "todoTODO3"));
    }

    @GetMapping("/todo")
    public List<TodoModel> getTodos() {
        return todos;
    }

    @GetMapping("/todo/{id}")
    public TodoModel getTodo(@PathVariable long id) {
        return todos.stream().filter(result -> result.getId() == id).findFirst().orElseGet(() -> null);
    }

    @GetMapping("/todo/search")
    public String getTodoByName(@RequestParam(defaultValue = "default") String name){
        return "search: " + name;
    }
}
