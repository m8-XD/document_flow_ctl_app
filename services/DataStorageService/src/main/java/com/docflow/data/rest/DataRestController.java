package com.docflow.data.rest;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.docflow.data.db.entity.Document;
import com.docflow.data.service.DataService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class DataRestController {

    private final DataService dataService;

    //TODO return status instead of void
    @GetMapping("/{id}")
    public String fetchDocument(UUID id, @RequestParam("key") String key) {
        return dataService.getDocumentById(id).toString();
    }

    @PostMapping
    public void publishDocument(@RequestBody Document document) {
        System.out.println(document.toString());
        dataService.save(document);
    }
}
