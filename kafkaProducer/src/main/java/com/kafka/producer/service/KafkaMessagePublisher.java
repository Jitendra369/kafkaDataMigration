package com.kafka.producer.service;

import com.kafka.producer.dto.ConsumerDto;
import com.kafka.producer.dto.KafkaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessageToTopic(KafkaDto kafkaDto){
        CompletableFuture<SendResult<String, Object>> featureMessage = kafkaTemplate.send(kafkaDto.getTopic(), kafkaDto.getMessage());
        featureMessage.whenComplete((result, exce)->{
            if (exce == null){
                System.out.println("sent message = [ " + kafkaDto.getMessage() + " ] " + "with offset = [ " + result.getRecordMetadata().offset() + " ]" );
            }else{
                System.out.println("unable to send message [ " + kafkaDto.getMessage() + " ] "+ "due to : "+ exce.getMessage());
            }
        });
    }

    public void sendConsumerMessage(ConsumerDto consumerDto){
        CompletableFuture<SendResult<String, Object>> featureMessage = kafkaTemplate.send(consumerDto.getTopic(), consumerDto);
        featureMessage.whenComplete((result, exce)->{
            if (exce == null){
                System.out.println("sent message = [ " +  consumerDto + " ] " + "with offset = [ " + result.getRecordMetadata().offset() + " ]" );
            }else{
                System.out.println("unable to send message [ " + consumerDto + " ] "+ "due to : "+ exce.getMessage());
            }
        });
    }
}
