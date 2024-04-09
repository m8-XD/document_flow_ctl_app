package com.docflow.userinteraction.http.rest;

import com.docflow.userinteraction.dto.UserCreateEditDTO;
import com.docflow.userinteraction.dto.UserReadDto;
import com.docflow.userinteraction.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
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

    @GetMapping("/")
    public String helloWorld(Principal principal,
            HttpServletResponse response) throws IOException {
        if (principal == null) {
            response.sendRedirect("/register");
            return "";
        }
        return principal.getName();
    }

    @PostMapping("/register")
    public void register(@ModelAttribute("user") UserCreateEditDTO user,
            Model model,
            HttpServletResponse response) throws IOException {
        Optional<UserReadDto> result = userService.createUser(user);

        if (result.isEmpty()) {
            response.sendRedirect("/register?error=409");
            return;
        }

        response.sendRedirect("/login");
        return;
    }
}
