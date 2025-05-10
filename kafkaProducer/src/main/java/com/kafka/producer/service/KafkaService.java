package com.kafka.producer.service;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsOptions;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ExecutionException;

@Service
public class KafkaService {

    @Autowired
    private KafkaAdmin kafkaAdmin;

    public Set<String> listAllTopic(){
        try(AdminClient adminClient = AdminClient.create(kafkaAdmin.getConfigurationProperties())){
            ListTopicsOptions listTopicsOptions = new ListTopicsOptions();
            listTopicsOptions.listInternal(false);
            ListTopicsResult listTopicsResult = adminClient.listTopics();
            return listTopicsResult.names().get();
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
            throw new RuntimeException("Filed to list kafka topics");
        }
    }
}
