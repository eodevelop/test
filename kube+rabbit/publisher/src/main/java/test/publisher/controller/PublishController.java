package test.publisher.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.publisher.service.MessagePublisher;

@RestController
public class PublishController {
    private final MessagePublisher messagePublisher;

    public PublishController(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    @GetMapping("/publish")
    public String publishMessage(@RequestParam String message) {
        messagePublisher.sendMessage(message);
        return "Message sent!";
    }
}
