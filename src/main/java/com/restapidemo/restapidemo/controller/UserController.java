package com.restapidemo.restapidemo.controller;

import com.restapidemo.restapidemo.model.User;
import com.restapidemo.restapidemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User newUser = userService.addNewUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("")
    public List<User> getUsers() {
        return userService.listUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {

        User user = userService.findUserById(id);
        if (user != null)
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> createUser(@RequestBody User user, @PathVariable Integer id) {
        User existingUser = userService.findUserById(id);
        if (existingUser == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        user.setId(id);
        userService.saveUpdatedUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id) {
        User existingUser = userService.findUserById(id);
        if (existingUser == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        userService.deleteUser(existingUser);
        return new ResponseEntity<>(existingUser, HttpStatus.OK);
    }
}
