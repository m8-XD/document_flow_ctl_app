package com.docflow.userinteraction;

import java.util.concurrent.ExecutionException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.docflow.userinteraction.service.KafkaService;

@SpringBootApplication
public class UserinteractionApplication {

    KafkaService kafkaService;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		SpringApplication.run(UserinteractionApplication.class, args);
	}
}
