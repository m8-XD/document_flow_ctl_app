package com.docflow.userinteraction.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class KafkaService {

    KafkaTemplate<String, String> kafkaTemplate;

    @Value("${service.data.kafka.topic-to}")
    String dataToKafkaTopicName;

    public void post(String data) {
        sendMessage(dataToKafkaTopicName, data);
    }

    private void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    @KafkaListener(topics = "${service.data.kafka.topic-from}", groupId = "${main-server-consumer-group}")
    private void listen(String message) {
    }
}
