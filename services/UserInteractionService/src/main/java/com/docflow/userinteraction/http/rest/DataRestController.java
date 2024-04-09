package com.docflow.userinteraction.http.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/data")
@AllArgsConstructor
@Slf4j
public class DataRestController {

    @Value("${data.server.port}")
    String dataServerPort;

    @PostMapping
    public void postData(@RequestBody DataDto data) {
        log.info("sending data to kafka");
        log.info(dataServerPort);
    }
}
