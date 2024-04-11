package com.docflow.data.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.docflow.data.db.entity.Document;
import com.docflow.data.dto.DocumentDto;

@Component
public class DocumentMapper {

    public Document map(DocumentDto documentDto) {
        return Document.builder()
            .uuid(documentDto.getUuid())
            .title(documentDto.getTitle())
            .desc(documentDto.getDesc())
            .data(documentDto.getData())
            .build();
    }
    public DocumentDto map(Document document) {
        return DocumentDto.builder()
            .uuid(document.getUuid())
            .title(document.getTitle())
            .desc(document.getDesc())
            .data(document.getData())
            .build();
    }
}
