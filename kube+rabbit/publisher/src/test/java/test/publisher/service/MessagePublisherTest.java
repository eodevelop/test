package test.publisher.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@ExtendWith(MockitoExtension.class)
class MessagePublisherTest {

    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private MessagePublisher messagePublisher;

    private final String queueName = "testQueue";

    @BeforeEach
    void setUp() {
        messagePublisher = new MessagePublisher(rabbitTemplate, queueName);
    }

    @Test
    void givenMessage_whenSendMessage_thenMessageIsSent() {
        // given
        String message = "Hello, World!";

        // when
        messagePublisher.sendMessage(message);

        // then
        verify(rabbitTemplate, times(1)).convertAndSend(queueName, message);
    }
}