package com.docflow.data.db.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.docflow.data.db.entity.Document;

@Repository
public interface DataRepository extends MongoRepository<Document, UUID> {
    Optional<Document> findById(UUID id);
}
