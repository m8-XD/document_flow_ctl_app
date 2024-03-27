package com.docflow.userinteraction.http.controller;

import com.docflow.userinteraction.dto.UserCreateEditDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        var user = new UserCreateEditDTO();
        model.addAttribute("user", user);
        return "registration";
    }
}
