package com.docflow.userinteraction.http.rest;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docflow.userinteraction.dto.DocumentCreateEditDto;
import com.docflow.userinteraction.dto.DocumentReadDto;
import com.docflow.userinteraction.service.DocumentService;
import com.docflow.userinteraction.service.KafkaService;
import com.docflow.userinteraction.service.UserService;
import com.docflow.userinteraction.utils.KafkaDataResolver;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
@Slf4j
public class DataRestController {

    @Value("${data.server.port}")
    private Integer dataServerPort;

    private final DocumentService documentService;
    private final UserService userService;

    private final KafkaDataResolver kafkaDataResolver;

    @PostMapping
    public ResponseEntity<String> postData(@RequestBody DocumentCreateEditDto data,
            Principal principal) {
        log.info("sending data to kafka");

        UUID userId = userService.getUserIdByUsername(principal.getName());
        data.setAuthorId(userId);
        documentService.postDocument(data);

        return ResponseEntity.status(HttpStatus.CREATED).body("data saved!\n");
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentReadDto> getDataById(@PathParam("id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(documentService.loadDocument(id));
    }
}
