package com.kafka.producer.config;

import com.kafka.producer.constant.ProducerTopic;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic createTopic(){
        return new NewTopic("msg-topic_1", 5, (short) 1);
    }

    @Bean
    public NewTopic sendUserInformation(){
        return new NewTopic(ProducerTopic.UPDATE_USER_TOPIC , 5, (short) 1);
    }
}
