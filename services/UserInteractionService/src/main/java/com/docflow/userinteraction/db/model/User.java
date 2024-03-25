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

@Table(name = "users")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column
    String username;

    @Column
    Integer role;

    @Column
    LocalDateTime created_at;

    @Column
    LocalDateTime updated_at;

    @Column
    LocalDateTime deleted_at;
}
