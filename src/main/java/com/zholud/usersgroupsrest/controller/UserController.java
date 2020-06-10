package com.zholud.usersgroupsrest.controller;

import com.zholud.usersgroupsrest.dto.impl.UserDto;
import com.zholud.usersgroupsrest.model.impl.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
public interface UserController {

    @GetMapping("/")
    ResponseEntity<List<UserDto>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<UserDto> findById(@PathVariable("id") long id);

    @PostMapping("/")
    ResponseEntity<?> createUser(@RequestBody UserDto userDto);

    @PutMapping("/")
    ResponseEntity<?> updateUser(@RequestBody UserDto userDto);

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteUser(@PathVariable("id") long id);
}
