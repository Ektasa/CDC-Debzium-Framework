package com.cdc.framework.model;

public class CustomerEvent {

    private String eventType;
    private Integer customerId;
    private String name;
    private String email;
    private String status;

    public CustomerEvent() {
    }

    public CustomerEvent(String eventType, Integer customerId, String name, String email, String status) {
        this.eventType = eventType;
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}