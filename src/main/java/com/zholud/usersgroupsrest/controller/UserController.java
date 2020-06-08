package com.zholud.usersgroupsrest.controller;

import com.zholud.usersgroupsrest.model.impl.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/users")
public interface UserController {

    @GetMapping("/")
    ResponseEntity<List<UserEntity>> read();
}
