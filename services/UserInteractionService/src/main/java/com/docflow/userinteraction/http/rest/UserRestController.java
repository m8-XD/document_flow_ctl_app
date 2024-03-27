package com.docflow.userinteraction.http.rest;

import com.docflow.userinteraction.db.entity.User;
import com.docflow.userinteraction.dto.UserCreateEditDTO;
import com.docflow.userinteraction.dto.UserReadDto;
import com.docflow.userinteraction.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserRestController {

    UserService userService;


    @PostMapping("/register")
    public String register(@ModelAttribute("user") UserCreateEditDTO user,
                           Model model,
                           HttpServletResponse response) throws IOException {
        Optional<UserReadDto> result = userService.createUser(user);

        if (result.isEmpty()) {
            model.addAttribute("usernameError", "User already exists");
            return "registration";
        }

        response.sendRedirect("/");
        return "";
    }

    @GetMapping("/")
    public String helloWorld(Principal principal,
                             HttpServletResponse response) throws IOException {
        if (principal == null) {
            response.sendRedirect("/register");
            return "";
        }
        return principal.getName();
    }

    @GetMapping("/protected")
    public String helloProtected() {
        return "Hello protected";
    }
}
