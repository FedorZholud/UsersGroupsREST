package com.zholud.usersgroupsrest.controller.impl;

import com.zholud.usersgroupsrest.controller.MainController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class MainControllerImpl implements MainController {

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
        return "user";
    }
}
