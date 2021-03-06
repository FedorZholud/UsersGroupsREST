package com.zholud.usersgroupsrest.controller.impl;

import com.zholud.usersgroupsrest.controller.ViewController;
import com.zholud.usersgroupsrest.controller.rest.UserController;
import com.zholud.usersgroupsrest.dto.impl.UserDto;
import com.zholud.usersgroupsrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class ViewControllerImpl implements ViewController {

    @Autowired
    UserService userService;

    @Autowired
    UserController userController;

    @Override
    public String home(Model model) {
        if (userService.getCurrentUser() != null)
            return "redirect:/messages";
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

    @Override
    public String registration(Model model) {
        return "registration";
    }

    @Override
    public String messages(Model model) {
        return "messages";
    }
}
