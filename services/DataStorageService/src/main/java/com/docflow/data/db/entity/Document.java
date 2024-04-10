package com.docflow.data.db.entity;

import java.util.Map;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@org.springframework.data.elasticsearch.annotations.Document(indexName = "documents")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Document {

    @Id
    @Field(name = "UUID", type = FieldType.Text)
    UUID uuid;
    
    @Field(name = "title", type = FieldType.Text)
    String title;

    @Field(name = "desc", type = FieldType.Text)
    String desc;

    @Field(name = "data", type = FieldType.Object)
    Map<String, ?> data;
}
