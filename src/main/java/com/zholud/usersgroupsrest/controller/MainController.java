package com.zholud.usersgroupsrest.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public interface MainController {

    @GetMapping("/")
    public String home(Model model);

    @GetMapping("/login")
    public String login(Model model);

    @GetMapping("/users")
    public String users(Model model);
}
