package com.docflow.userinteraction.http.rest;

import org.springframework.beans.factory.annotation.Value;
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
    public void postData(@RequestBody Object data) {
        log.info("sending data to kafka");
        log.info(dataServerPort.toString());
        log.info(data.toString());
    }
}
