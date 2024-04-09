package com.docflow.userinteraction.http.controller;

import com.docflow.userinteraction.dto.UserCreateEditDTO;
import com.docflow.userinteraction.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@Slf4j
public class UserController {

    UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(@RequestParam(name = "error", required = false) String error,
            Model model) {
        if (error != null && !error.isBlank()) {
            if ("409".equals(error)) {
                model.addAttribute("usernameError", "user exists");
                log.info("trying to create existing user, retrurning an error");
            }
        }
        model.addAttribute("user", new UserCreateEditDTO());
        return "registration";
    }

}
