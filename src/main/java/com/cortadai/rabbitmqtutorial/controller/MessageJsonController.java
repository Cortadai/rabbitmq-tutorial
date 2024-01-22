package com.cortadai.rabbitmqtutorial.controller;

import com.cortadai.rabbitmqtutorial.dto.UserDto;
import com.cortadai.rabbitmqtutorial.publisher.RabbitMqJsonPublisher;
import com.cortadai.rabbitmqtutorial.publisher.RabbitMqPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

    private RabbitMqJsonPublisher publisher;

    public MessageJsonController(RabbitMqJsonPublisher publisher) {
        this.publisher = publisher;
    }

    // http://localhost:8080/api/v1/publish
    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody UserDto dto){
        publisher.sendJsonMessage(dto);
        return ResponseEntity.ok("Json message sent to RabbitMQ ...");
    }
    
}
