package com.cdc.framework.utils;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class BusinessEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public BusinessEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(String topic, String key, String event) {
        kafkaTemplate.send(topic, key, event);
    }
}
