package com.sbt.exercises.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbt.exercises.model.Dto.UserDto;

@RestController
public class UserController {

    private List<UserDto> users = new ArrayList<>(Arrays.asList(
        new UserDto(1L, "John Doe", "john.doe@example.com", "password", true),
        new UserDto(2L, "Jane Doe", "jane.doe@example.com", "password", true),
        new UserDto(3L, "Jim Doe", "jim.doe@example.com", "password", false)
    ));

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return users;
    }

    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return users.stream()
            .filter(user -> user.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    @PostMapping("/users")
    public UserDto createUser(@RequestBody UserDto user) {
        users.add(user);
        return user;
    }

    @PutMapping("/users/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto user) {
        users.stream()
            .filter(u -> u.getId().equals(id))
            .findFirst()
            .orElse(null);
        user.setId(id);
        return user;
    }
}
