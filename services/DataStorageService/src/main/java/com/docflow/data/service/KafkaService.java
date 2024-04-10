package com.docflow.data.service;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KafkaService {

    @Value("${service.data.kafka.topic-from}")
    private String dataToKafkaTopicName;

    private final DataService dataService;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void post(String data) {
        sendMessage(dataToKafkaTopicName, data);
    }

    private void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    @KafkaListener(topics = "${service.data.kafka.topic-to}", groupId = "${spring.kafka.consumer.group-id}")
    private void listen(String message) {
    }
}
