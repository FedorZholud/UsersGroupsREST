package com.zholud.usersgroupsrest.controller.impl;

import com.zholud.usersgroupsrest.controller.MainController;
import com.zholud.usersgroupsrest.controller.rest.UserController;
import com.zholud.usersgroupsrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class MainControllerImpl implements MainController {

    @Autowired
    UserService userService;

    @Autowired
    UserController userController;

    @Override
    public String home(Model model) {
        return "home";
    }

    @Override
    public String login(Model model) {
        return "login";
    }

    @Override
    public String users(Model model) {
        model.addAttribute("user", userController.findById(userService.getCurrentUserId()).getBody());
        return "user";
    }
}
