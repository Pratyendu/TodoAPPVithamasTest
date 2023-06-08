package com.test.todo.controllers;

import com.test.todo.models.User;
import com.test.todo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(value = "/register-user")
    public ResponseEntity<User> registerUser(@RequestBody @Valid User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PostMapping(value = "log-in")
    public ResponseEntity<String> logIn(@RequestParam String username,@RequestParam String password){
        boolean flag = userService.login(username , password);
        if(flag){
            return new ResponseEntity<>("Login Successful" , HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Please enter valid username and password" , HttpStatus.BAD_REQUEST);
        }
    }
}
