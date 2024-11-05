package test.publisher.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisher {
    private final RabbitTemplate rabbitTemplate;
    private final String queueName;

    public MessagePublisher(RabbitTemplate rabbitTemplate, @Value("${rabbitmq.queue}") String queueName) {
        this.rabbitTemplate = rabbitTemplate;
        this.queueName = queueName;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(queueName, message);
        System.out.println("Sent message: " + message);
    }
}
