package com.docflow.userinteraction.http.rest;

import java.io.IOException;
import java.security.Principal;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docflow.userinteraction.service.UserService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
@Slf4j
public class AdminRestController {

    UserService userService;

    @GetMapping("/users/{id}/delete")
    public void deleteUser(@PathVariable UUID id,
            Principal principal,
            HttpServletResponse response) throws IOException {
        userService.deleteUserById(id);

        log.info("user with id:{} have been deleted by {}", id.toString(), principal.getName());
        response.sendRedirect( "/admin/users");
    }

    @GetMapping("/users/{id}/changerole")
    public void changeRole(@PathVariable UUID id,
            Principal principal,
            HttpServletResponse response) throws IOException {
        userService.changeRole(id);
    
        log.info("role of user with id:{} have been chantged by {}", id.toString(), principal.getName());
        response.sendRedirect( "/admin/users/" + id);
    }
}
