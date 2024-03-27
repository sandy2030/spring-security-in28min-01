package com.learning.learnspringsecurity.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {

    private Logger logger= LoggerFactory.getLogger(getClass());
    public static final List<Todo> TODO_LIST = List.of(new Todo("Sandy", "Finish microservices first"),
            new Todo("Sandy", "finish spring security second"));

    @GetMapping("/todos")
    public List<Todo>  retrieveAllTodos() {
        return TODO_LIST;
    }

    @GetMapping("/users/{username}/todos")
    public Todo  retrieveTodosForSpecificUser(@PathVariable String username) {
        return TODO_LIST.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void  retrieveTodosForSpecificUser(@PathVariable String username, @RequestBody Todo  todo ) {
       logger.info("create {} for {} ",todo,username);
    }
}

record Todo(String username,String description){}