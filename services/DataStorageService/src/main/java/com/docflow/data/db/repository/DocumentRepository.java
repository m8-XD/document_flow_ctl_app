package com.docflow.data.db.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.docflow.data.db.entity.Document;

@Repository
public interface DocumentRepository extends ElasticsearchRepository<Document, String> {

}
