package com.docflow.userinteraction.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;

@Component
@Slf4j
public class KafkaDataResolver {

    private Map<UUID, CompletableFuture<JSONObject>> listeners = new HashMap<>();

    public Future<JSONObject> acceptMessage(UUID id) {
        var future = new CompletableFuture<JSONObject>();
        listeners.put(id, future);
        return future;
    }

    public void processMessage(String message) {
        LinkedHashMap<String, Object> parsedJSON;
		try {
			parsedJSON = new JSONParser(message).parseObject();
		} catch (ParseException e) {
            log.info("error while parsing json: " + message);
            return;
		}
        var json = new JSONObject(parsedJSON);
        var key = UUID.fromString(json.get("key").toString());
        listeners.get(key).complete(json);
        listeners.remove(key);
    }
}
