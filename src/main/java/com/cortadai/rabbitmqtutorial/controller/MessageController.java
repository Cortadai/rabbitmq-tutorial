package com.cortadai.rabbitmqtutorial.controller;

import com.cortadai.rabbitmqtutorial.publisher.RabbitMqPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitMqPublisher publisher;

    public MessageController(RabbitMqPublisher publisher) {
        this.publisher = publisher;
    }

    // http://localhost:8080/api/v1/publish?message=hello
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        publisher.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }

}
