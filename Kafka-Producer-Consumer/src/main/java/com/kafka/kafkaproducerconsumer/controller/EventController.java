package com.kafka.kafkaproducerconsumer.controller;

import com.kafka.kafkaproducerconsumer.service.KafkaMessagePub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class EventController {
    @Autowired
    private KafkaMessagePub kafkaMessagePub;

    @GetMapping("/producer/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message){
        try {
           for(int i=0;i<=9999;i++){
               kafkaMessagePub.sendMessage(message+": "+ i);
           }
            return ResponseEntity.ok("message sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
