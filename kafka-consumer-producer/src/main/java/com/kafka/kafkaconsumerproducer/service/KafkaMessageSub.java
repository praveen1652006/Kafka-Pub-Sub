package com.kafka.kafkaconsumerproducer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageSub {

    private static final Logger log = LoggerFactory.getLogger(KafkaMessageSub.class);

    @KafkaListener(topics = "kafkaDemo1", groupId = "kafka-demo-1")
    public void subscribe(String message){
        log.info("consumer consumed the message: {}", message);

    }

    @KafkaListener(topics = "kafkaDemo1", groupId = "kafka-demo-1")
    public void subscribe1(String message){
        log.info("consumer1 consumed the message: {}", message);

    }

    @KafkaListener(topics = "kafkaDemo1", groupId = "kafka-demo-1")
    public void subscribe2(String message){
        log.info("consumer2 consumed the message: {}", message);

    }

    @KafkaListener(topics = "kafkaDemo1", groupId = "kafka-demo-1")
    public void subscribe3(String message){
        log.info("consumer3 consumed the message: {}", message);

    }
}
