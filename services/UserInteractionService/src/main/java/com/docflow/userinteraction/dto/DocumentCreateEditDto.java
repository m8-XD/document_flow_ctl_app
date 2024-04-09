package com.docflow.userinteraction.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentCreateEditDto {
    
    Integer authorId;
    Map<String, ?> data;
}
