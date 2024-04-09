package com.docflow.userinteraction.http.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.docflow.userinteraction.dto.UserReadDto;
import com.docflow.userinteraction.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    private final UserService userService;

    @GetMapping("/users")
    public String showAllUsersList(Model model) {
        List<UserReadDto> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/users";
    }

    @GetMapping("/users/{id}")
    public String showUserInfo(@PathVariable UUID id, Model model) {
        log.debug("returning user info id:" + id);
        UserReadDto user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user";
    }
}
