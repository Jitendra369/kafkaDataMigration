package com.kafka.producer.controller;

import com.kafka.producer.dto.ConsumerDto;
import com.kafka.producer.dto.KafkaDto;
import com.kafka.producer.service.KafkaMessagePublisher;
import com.kafka.producer.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/kafka/producer")
public class KafkaMessageController {

    @Autowired
    private KafkaMessagePublisher kafkaPublisher;

    @Autowired
    private KafkaService kafkaService;

    @PostMapping
    public void publishMessage(@RequestBody KafkaDto kafkaDto){
        try{
            for (int i = 0; i < 10000; i++) {
                kafkaPublisher.sendMessageToTopic(kafkaDto);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @PostMapping("/customer")
    public void sendConsumerMessage(@RequestBody ConsumerDto consumerDto){
        try{
            for (int i = 0; i < 10000; i++) {
                kafkaPublisher.sendConsumerMessage(consumerDto);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping(path = "/topics/all")
    public Set<String> getAllTopics(){
        return kafkaService.listAllTopic();
    }
}
