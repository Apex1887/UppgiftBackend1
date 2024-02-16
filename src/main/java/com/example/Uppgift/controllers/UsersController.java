package com.example.Uppgift.controllers;

import com.example.Uppgift.models.Users;
import com.example.Uppgift.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping
    public ResponseEntity<Users> createUsers(@RequestBody Users users){
        Users createdUsers = usersService.createUsers(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUsers);
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUsers(@PathVariable String id, @RequestBody Users users) {
        Users updatedUsers = usersService.updateUsers(id, users);
        return ResponseEntity.ok(updatedUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUsersById(@PathVariable String id) {
        Users user = usersService.getUsersById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsers(@PathVariable String id) {
        usersService.deleteUsers(id);
        return ResponseEntity.ok("User with id: " + id + " has been deleted!");
    }

}