package com.prometheus.ToDoList.controller;

import com.prometheus.ToDoList.db.service.api.UserService;
import com.prometheus.ToDoList.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController (UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity add (@RequestBody User user){
        Integer id = userService.add(user);
        if (id != null){
            return new ResponseEntity <> (id, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable("id") int id){
        User user = userService.get(id);
        if (user !=  null){
            return new ResponseEntity<>(user,HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity getAll (){
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

}
