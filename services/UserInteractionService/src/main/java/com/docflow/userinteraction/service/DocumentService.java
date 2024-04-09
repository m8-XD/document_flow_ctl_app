package com.docflow.userinteraction.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.docflow.userinteraction.db.entity.Document;
import com.docflow.userinteraction.db.repository.DocumentRepository;
import com.docflow.userinteraction.dto.DocumentCreateEditDto;
import com.docflow.userinteraction.mapper.DocumentMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;

@Service
@AllArgsConstructor
@Slf4j
public class DocumentService {

    DocumentRepository documentRepository;
    DocumentMapper documentMapper;
    KafkaService kafkaService;

    public void postDocument(DocumentCreateEditDto documentCreateEditDto) {
        Document document = documentRepository.save(documentMapper.map(documentCreateEditDto));
        Map<String, ?> data = documentCreateEditDto.getData();
        var json = new JSONObject(data);
        json.appendField("UUID", document.getId().toString());
        log.info("sending json: " + json.toString());
        kafkaService.post(json.toString());
    }
}
