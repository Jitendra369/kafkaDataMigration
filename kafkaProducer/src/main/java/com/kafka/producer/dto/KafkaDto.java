package com.kafka.producer.dto;


public class KafkaDto {
    public String topic;
    public String message;

    public KafkaDto() {
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
