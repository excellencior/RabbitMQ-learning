package com.demo.listener;

import com.demo.config.RabbitConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.demo.config.RabbitConfig.QUEUE;

/**
 * @author apurboturjo
 * @since 10/16/25
 */
@Component
public class MessageListener {

//    /**
//     * @param msg to acknowledge after receiving the message
//     *            AcknowledgeMode.AUTO : Default
//     */
//    @RabbitListener(queues = QUEUE)
//    public void handle(String msg) {
//        System.out.println("Received: " + msg);
//    }

    @RabbitListener(queues = QUEUE)
    public void handle(String msg, Channel channel, Message message) throws IOException {
        System.out.println("Received: " + msg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
