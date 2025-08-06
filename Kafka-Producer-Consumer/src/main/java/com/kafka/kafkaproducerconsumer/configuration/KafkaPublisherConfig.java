package com.kafka.kafkaproducerconsumer.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaPublisherConfig {

    @Bean
    public NewTopic createTopic(){
        return new NewTopic("kafkaDemo1",3,(short) 1);
    }
}
