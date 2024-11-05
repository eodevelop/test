package test.publisher.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import test.publisher.service.MessagePublisher;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(PublishController.class)
class PublishControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessagePublisher messagePublisher;

    @Test
    void givenMessage_whenPublishMessage_thenMessageIsSent() throws Exception {
        // given
        String message = "Hello, World!";
        doNothing().when(messagePublisher).sendMessage(message);

        // when & then
        mockMvc.perform(get("/publish")
                        .param("message", message))
                .andExpect(status().isOk())
                .andExpect(content().string("Message sent!"));

        verify(messagePublisher, times(1)).sendMessage(message);
    }
}