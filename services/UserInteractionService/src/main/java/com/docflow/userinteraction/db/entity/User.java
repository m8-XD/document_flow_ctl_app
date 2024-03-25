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

@Table(name = "users")
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
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
