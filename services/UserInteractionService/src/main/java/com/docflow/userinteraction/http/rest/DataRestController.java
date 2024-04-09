package com.docflow.userinteraction.http.rest;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
@Slf4j
public class DataRestController {

    @Value("${data.server.port}")
    private Integer dataServerPort;

    @PostMapping
    public ResponseEntity<String> postData(@RequestBody Map<String, String> data,
            Principal principal) {
        log.info("sending data to kafka");
        if (!data.containsKey("title")) {
            log.warn("data posted by {} doesn't have 'title' field", principal.getName());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("error: no 'title' field\n");
        }
        if (!data.containsKey("desc")) {
            log.warn("data posted by {} doesn't have 'desc' field", principal.getName());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("error: no 'desc' field\n");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("data saved!\n");
    }
}
