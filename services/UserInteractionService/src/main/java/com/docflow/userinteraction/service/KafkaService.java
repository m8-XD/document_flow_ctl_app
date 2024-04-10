package com.docflow.userinteraction.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.docflow.userinteraction.utils.KafkaDataResolver;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaService {

    @Value("${service.data.kafka.topic-to}")
    private String dataToKafkaTopicName;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaDataResolver kafkaDataResolver;

    public void post(String data) {
        sendMessage(dataToKafkaTopicName, data);
    }

    public String loadPost(UUID id) {
        // TODO
        // make rest request for fetching the data
        // listend from kafka for that data
        // return that data
        throw new UnsupportedOperationException();
    }

    private void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    @KafkaListener(topics = "${service.data.kafka.topic-from}", groupId = "${spring.kafka.consumer.group-id}")
    private void listen(String message) {
        kafkaDataResolver.processMessage(message);
    }
}
