package com.docflow.data.dto;

import java.util.Map;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDto {

    UUID uuid;
    String title;
    String desc;
    Map<String, ?> data;
}
