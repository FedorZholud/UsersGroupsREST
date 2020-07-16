package com.zholud.usersgroupsrest.controller;

import com.zholud.usersgroupsrest.dto.impl.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface ViewController {

    @GetMapping("/")
    String home(Model model);

    @GetMapping("/login")
    String login(Model model);

    @GetMapping("/users")
    String users(Model model);

    @GetMapping("/signup")
    String registration(Model model);
}
