package com.zholud.usersgroupsrest.controller;

import com.zholud.usersgroupsrest.dto.impl.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
public interface UserController {

    @GetMapping("/")
    ResponseEntity<List<UserDto>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<UserDto> findById(@PathVariable("id") long id);
}
