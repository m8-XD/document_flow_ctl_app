package com.docflow.userinteraction.dto;

import com.docflow.userinteraction.db.entity.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserReadDto {
    UUID id;
    String username;
    String passwordEnc;
    ERole role;
    LocalDateTime createdAt;
}
