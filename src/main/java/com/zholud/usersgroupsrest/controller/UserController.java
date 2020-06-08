package com.zholud.usersgroupsrest.controller;

import com.zholud.usersgroupsrest.model.impl.UserEntity;
import com.zholud.usersgroupsrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserEntity>> read() {
        final List<UserEntity> userEntities = userService.findAll();

        return userEntities != null && !userEntities.isEmpty()
                ? new ResponseEntity<>(userEntities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
