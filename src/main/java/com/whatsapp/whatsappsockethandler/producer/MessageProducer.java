package com.whatsapp.whatsappsockethandler.producer;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.whatsapp.whatsappsockethandler.dto.QueueMessage;

import io.awspring.cloud.sns.core.SnsTemplate;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class MessageProducer {
    private final SnsTemplate snsTemplate;

    public void sendMessage(QueueMessage queueMessage) {
        Message<QueueMessage> message = MessageBuilder.withPayload(queueMessage)
                .setHeader("message-group-id", "messageGroupId")
                .setHeader("message-deduplication-id", "str")
                .build();
        snsTemplate.send("message-received-dev.fifo", message);
    }
}