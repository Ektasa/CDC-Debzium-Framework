package com.cdc.framework.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "cdc.framework")
public class CdcFrameworkProperties {
    private final Routing routing =new Routing();
    private final Kafka kafka = new Kafka();
    private final Pipeline pipeline = new Pipeline();   
    private final Security security = new Security();
    private final Storage storage = new Storage();

    public Routing getRouting()
    {
        return routing;
    }
    public Kafka getKafka()
    {
        return kafka;
    }   
    public Pipeline getPipeline()
    {
        return pipeline;
    }
    public Security getSecurity()
    {
        return security;
    }
    public Storage getStorage()
    {
        return storage;
    }
    
    
}
public static class Storage{
   
    private String path="./data/debezium";

   
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
public static class Routing{
    private String destination="DATABASE";

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
public static class Kafka{
    private String bootstrapServers="localhost:9092";
    private String topic="PER_TABLE";
    private String defaultTopic="cdc.events";

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}

public static class Pipeline{
    private String defaultSnapshotMode="default-pipeline";
    private int maxConcurrent=5;
    public String getDefaultSnapshotMode() {
        return defaultSnapshotMode;
    }

    public void setDefaultSnapshotMode(String defaultSnapshotMode) {
        this.defaultSnapshotMode = defaultSnapshotMode;
    }
    public int getMaxConcurrent() {
        return maxConcurrent;
    }
    public void setMaxConcurrent(int maxConcurrent) {
        this.maxConcurrent = maxConcurrent;
    }
}

public static class Security{
    private String simpleSecretKey="change-this-key";
   

    public String getSimpleSecretKey() {
            return simpleSecretKey;
        }
    public void setSimpleSecretKey(String simpleSecretKey) {
        this.simpleSecretKey = simpleSecretKey;
    }
}
