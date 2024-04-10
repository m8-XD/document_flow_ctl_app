package com.docflow.data.rest;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.elastic.clients.elasticsearch.ingest.simulate.Document;

@RestController
@RequestMapping("/data")
public class DataRestController {

    //TODO return status instead of void
    @GetMapping("/{id}")
    public void fetchDocument(UUID id, @RequestParam("key") String key) {
// search in elastic search with id
    
    }

    @PostMapping
    public void publishDocument(@RequestBody Document document) {
        System.out.println(document.toString());
    }
}
