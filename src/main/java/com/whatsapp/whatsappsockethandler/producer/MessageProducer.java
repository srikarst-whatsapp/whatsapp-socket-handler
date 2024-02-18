package com.whatsapp.whatsappsockethandler.producer;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.whatsappsockethandler.dto.QueueMessage;

import io.awspring.cloud.sns.core.SnsTemplate;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class MessageProducer {
    private final SnsTemplate snsTemplate;
    private final ObjectMapper objectMapper;

    public void sendMessage(QueueMessage queueMessage) {
        String messageString;
        try {
            messageString = objectMapper.writeValueAsString(queueMessage);
            Message<String> message = MessageBuilder.withPayload(messageString)
                    .setHeader("message-group-id", queueMessage.getChatId())
                    .setHeader("message-deduplication-id", queueMessage.getId())
                    .build();
            snsTemplate.send("message-received-dev.fifo", message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}