package com.kafka.kafkaproducerconsumer.controller;

import com.kafka.kafkaproducerconsumer.model.User;
import com.kafka.kafkaproducerconsumer.service.KafkaMessagePub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/producer/user")
    public ResponseEntity<?> publishMessage(@RequestBody User user){
        try {
            for(int i=0;i<=9999;i++){
                kafkaMessagePub.sendUserMessage(user);
            }
            return ResponseEntity.ok("user sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
