package com.kafka.kafkaproducerconsumer.service;

import com.kafka.kafkaproducerconsumer.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageSub {

    private static final Logger log = LoggerFactory.getLogger(KafkaMessageSub.class);

    @KafkaListener(topics = "kafkaSd", groupId = "kafka-demo-1")
    public void subscribe(User user){
        log.info("consumer consumed the message: {}", user.toString());

    }

    @KafkaListener(topics = "kafkaSd", groupId = "kafka-sd-1")
    public void subscribe1(User user){
        log.info("consumer1 consumed the message: {}", user.toString());

    }

    @KafkaListener(topics = "kafkaSd", groupId = "kafka-sd-1")
    public void subscribe2(User user){
        log.info("consumer2 consumed the message: {}", user.toString());

    }

    @KafkaListener(topics = "kafkaSd", groupId = "kafka-sd-1")
    public void subscribe3(User user){
        log.info("consumer3 consumed the message: {}", user.toString());

    }
}
