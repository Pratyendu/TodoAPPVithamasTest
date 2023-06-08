package com.test.todo.controllers;

import com.test.todo.models.Todo;
import com.test.todo.services.TodoService;
import com.test.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @Autowired
    private UserService userService;

    @PostMapping(value = "create-todo")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo , @RequestParam String username ,@RequestParam String password){

        return new ResponseEntity<>(todoService.save(todo , username , password) , HttpStatus.CREATED);

    }

    @GetMapping(value = "get-todos")
    public List<Todo> getTodos(@RequestParam String username , @RequestParam String password){
        List<Todo> todoList = todoService.getTodos(username,password);
        return todoList;
    }

    @PutMapping(value = "update-todos")
    public ResponseEntity<String> updateTodos(@RequestParam Integer todoId ,@RequestParam String username ,@RequestParam String password, @RequestBody Todo todo){
       if(todoService.updateTodo(todoId , username , password , todo)){
           return new ResponseEntity<>("Todo updated with id : " + todoId , HttpStatus.OK);
       }
        return new ResponseEntity<>("Please check username , password , todoId and try again!" , HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "delete-todo")
    public ResponseEntity<String> updateTodos(@RequestParam Integer todoId ,@RequestParam String username ,@RequestParam String password){
        todoService.deleteTodo(todoId,username,password);
        return new ResponseEntity<>("Todo deleted with id : " + todoId , HttpStatus.OK);
    }

}
