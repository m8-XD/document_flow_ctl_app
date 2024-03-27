package com.docflow.userinteraction.http.rest;

import com.docflow.userinteraction.db.entity.User;
import com.docflow.userinteraction.dto.UserCreateEditDTO;
import com.docflow.userinteraction.dto.UserReadDto;
import com.docflow.userinteraction.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {

    UserService userService;


    @PostMapping("/register")
    public String register(@ModelAttribute("user") UserCreateEditDTO user,
                           Model model) {
        Optional<UserReadDto> result = userService.createUser(user);

        if (result.isEmpty()) {
            model.addAttribute("usernameError", "User already exists");
            return "registration";
        }

        return "redirect:/";
    }

    @GetMapping("/")
    public String helloWorld(@AuthenticationPrincipal User user) {
        return user.getUsername();
    }

    @GetMapping("/protected")
    public String helloProtected() {
        return "Hello protected";
    }
}
