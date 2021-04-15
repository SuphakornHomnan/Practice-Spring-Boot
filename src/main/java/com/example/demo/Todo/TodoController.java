package com.example.demo.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    private List<TodoModel> todos = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public TodoController() {
        // Default constructor
    }

    @GetMapping("/todo")
    public List<TodoModel> getTodos() {
        return todos;
    }

    @GetMapping("/todo/{id}")
    public TodoModel getTodo(@PathVariable long id) {
        return todos.stream().filter(result -> result.getId() == id).findFirst()
        .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @GetMapping("/todo/search")
    public String getTodoByName(@RequestParam(defaultValue = "default") String name) {
        return "search: " + name;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/todo")
    public void createTodo(@RequestBody TodoModel todo) {
        todos.add(new TodoModel(counter.getAndIncrement(), todo.getName()));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/todo/{id}")
    public void editTodoName(@RequestBody TodoModel todo, @PathVariable long id) {
        todos.stream().filter(result -> result.getId() == id).findFirst()
                .ifPresentOrElse(result -> result.setName(todo.getName()), () -> {
                    throw new TodoNotFoundException(id);
                });
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/todo/{id}")
    public void deleteTodo(@PathVariable long id) {
        todos.stream().filter(result -> result.getId() == id).findFirst().ifPresentOrElse(result -> {
            todos.remove(result);
        }, () -> {
            throw new TodoNotFoundException(id);
        });
    }
}
