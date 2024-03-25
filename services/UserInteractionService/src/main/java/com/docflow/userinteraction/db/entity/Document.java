package com.docflow.userinteraction.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "document")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column
    Integer creator;

    @Column
    UUID content_id;

    @Column
    LocalDateTime created_at;

    @Column
    LocalDateTime updated_at;

    @Column
    LocalDateTime deleted_at;
}
