package com.cdc.framework.service;

import com.cdc.framework.utils.BusinessEventProducer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class EventTransformationService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final BusinessEventProducer producer;
    private final String customerTopic;
    private final String orderTopic;

    public EventTransformationService(
            BusinessEventProducer producer,
            @Value("${app.topics.customer-events:customer-events}") String customerTopic,
            @Value("${app.topics.order-events:order-events}") String orderTopic) {
        this.producer = producer;
        this.customerTopic = customerTopic;
        this.orderTopic = orderTopic;
    }

    public void transformCustomer(String rawEvent) {
        publishBusinessEvent(rawEvent, "customer", customerTopic);
    }

    public void transformOrder(String rawEvent) {
        publishBusinessEvent(rawEvent, "order", orderTopic);
    }

    private void publishBusinessEvent(String rawEvent, String entity, String topic) {
        try {
            JsonNode envelope = objectMapper.readTree(rawEvent);
            JsonNode payload = envelope.has("payload") ? envelope.get("payload") : envelope;
            String operation = payload.path("op").asText();
            JsonNode record = "d".equals(operation) ? payload.path("before") : payload.path("after");
            if (record.isMissingNode() || record.isNull()) {
                return;
            }

            Map<String, Object> event = new LinkedHashMap<>();
            event.put("eventType", eventType(entity, operation));
            event.put("operation", operation);
            event.put("occurredAt", payload.path("ts_ms").asLong());
            event.put("data", objectMapper.convertValue(record, Map.class));

            String key = record.has("id") ? record.get("id").asText() : null;
            producer.publish(topic, key, objectMapper.writeValueAsString(event));
        } catch (Exception exception) {
            throw new IllegalArgumentException("Unable to transform Debezium event", exception);
        }
    }

    private String eventType(String entity, String operation) {
        String action = switch (operation) {
            case "c", "r" -> "created";
            case "u" -> "updated";
            case "d" -> "deleted";
            default -> throw new IllegalArgumentException("Unsupported Debezium operation: " + operation);
        };
        return entity + " " + action;
    }
}
