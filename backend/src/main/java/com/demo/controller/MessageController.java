package com.demo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.demo.config.RabbitConfig.EXCHANGE;
import static com.demo.config.RabbitConfig.ROUTING_KEY;

/**
 * @author apurboturjo
 * @since 10/16/25
 */
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final RabbitTemplate rabbitTemplate;

    public MessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public ResponseEntity<String> send(@RequestBody Map<String, String> body) {
        String payload = body.getOrDefault("msg", "hello");
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, payload);

        return ResponseEntity.ok("sent");
    }
}
