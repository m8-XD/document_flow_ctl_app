package com.docflow.userinteraction.db.repository;

import com.docflow.userinteraction.db.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
@Transactional
public interface DocumentRepository extends JpaRepository<Document, UUID> {
}
