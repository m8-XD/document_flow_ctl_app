package com.docflow.data.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.docflow.data.db.repository.DocumentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DataService {

    DocumentRepository documentRepository;

    public void save() {
        //TODO save with mongo
        documentRepository.save();
    }

    public void getDocumentById(UUID id) {
        // TODO search data by id using mongo
    }

    public void searchAllWith(List<String> wordList) {
        // TODO search with wordlist using elastic search
    }

}
