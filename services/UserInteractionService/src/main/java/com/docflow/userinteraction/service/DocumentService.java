package com.docflow.userinteraction.service;

import org.springframework.stereotype.Service;

import com.docflow.userinteraction.db.repository.DocumentRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class DocumentService {

    DocumentRepository documentRepository;

    public void postDocument(DocumentCreateEditDto documentCreateEditDto) {

    }
}
