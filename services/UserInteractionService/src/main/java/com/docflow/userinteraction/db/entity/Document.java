package com.docflow.userinteraction.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "document")
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column
    Integer creator;

    @Column
    LocalDateTime created_at;

    @Column
    LocalDateTime deleted_at;
}
