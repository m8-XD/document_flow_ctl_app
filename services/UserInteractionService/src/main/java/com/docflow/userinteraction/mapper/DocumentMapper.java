package com.docflow.userinteraction.mapper;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.docflow.userinteraction.db.entity.Document;
import com.docflow.userinteraction.dto.DocumentCreateEditDto;
import com.docflow.userinteraction.dto.DocumentReadDto;
import com.docflow.userinteraction.service.KafkaService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DocumentMapper {

    KafkaService kafkaService;

    public Document map(DocumentCreateEditDto documentCreateEditDto) {
       UUID documentId =  kafkaService.post(documentCreateEditDto.getData());
        return Document.builder()
                .creator(documentCreateEditDto.getAuthorId())
                .content_id(documentId)
                .created_at(LocalDateTime.now())
                .build();
    }

    public DocumentReadDto map(Document document) {
        String data = kafkaService.loadPost(document.getContent_id());
        return DocumentReadDto.builder()
            .authorId(document.getCreator())
            .data(data)
            .build();
    } 
}
