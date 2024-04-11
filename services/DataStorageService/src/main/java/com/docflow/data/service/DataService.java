package com.docflow.data.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.docflow.data.db.entity.Document;
import com.docflow.data.db.repository.DataRepository;
import com.docflow.data.dto.DocumentDto;
import com.docflow.data.es.repository.ElasticRepository;
import com.docflow.data.mapper.DocumentMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DataService {

    ElasticRepository elasticRepository;
    DataRepository dataRepository;
    DocumentMapper documentMapper;

    public void save(Document document) {
        dataRepository.save(document);
    }

    public DocumentDto getDocumentById(UUID id) {
        return documentMapper
            .map(dataRepository.findById(id)
                .orElse(new Document()));
    }

    public void searchAllWith(List<String> wordList) {
        // TODO search with wordlist using elastic search
    }

}
