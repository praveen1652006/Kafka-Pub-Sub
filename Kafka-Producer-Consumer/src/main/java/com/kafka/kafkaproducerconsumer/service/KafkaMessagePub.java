package com.kafka.kafkaproducerconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePub {

    @Autowired
    private KafkaTemplate<String,Object> template;

    public void sendMessage(String message){
        CompletableFuture<SendResult<String, Object>> kafkaDemo = template.send("kafkaDemo1", message);
        kafkaDemo.whenComplete((result,error)->{
            if(error == null){
                System.out.println("Sent message=["+ message +
                        "] with offset=[" + result.getRecordMetadata().offset());
            }
            else {
                System.out.println("Unable to send message=[" +
                        message + "] due to: "+error.getMessage());
            }
        });

    }
}
