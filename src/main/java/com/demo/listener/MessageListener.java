package com.demo.listener;

import com.demo.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author apurboturjo
 * @since 10/16/25
 */
@Component
public class MessageListener {

    /**
     * @param msg to acknowledge after receiving the message
     */
    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void handle(String msg) {
        System.out.println("Received: " + msg);
    }
}
