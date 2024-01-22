package com.cortadai.rabbitmqtutorial.publisher;

import com.cortadai.rabbitmqtutorial.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqJsonPublisher {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqJsonPublisher.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key.name}")
    private String routingKeyJson;

    private RabbitTemplate template;

    public RabbitMqJsonPublisher(RabbitTemplate template) {
        this.template = template;
    }

    public void sendJsonMessage(UserDto dto){
        LOGGER.info(String.format("Json message sent -> %s", dto.toString()));
        template.convertAndSend(exchange, routingKeyJson, dto);
    }
}
