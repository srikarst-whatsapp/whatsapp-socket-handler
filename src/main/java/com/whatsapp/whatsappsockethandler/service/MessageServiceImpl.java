package com.whatsapp.whatsappsockethandler.service;

import com.whatsapp.whatsappsockethandler.dto.BaseMessage;
import com.whatsapp.whatsappsockethandler.dto.QueueMessage;
import com.whatsapp.whatsappsockethandler.dto.UserMessage;
import com.whatsapp.whatsappsockethandler.producer.MessageProducer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {
    private final MessageProducer messageProducer;

    @Override
    public QueueMessage convertUserMessageToQueueMessage(BaseMessage baseMessage) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        QueueMessage queueMessage = new QueueMessage(baseMessage);
        queueMessage.setSender(authentication.getPrincipal().toString());
        return queueMessage;
    }

    @Override
    public QueueMessage handleMessage(UserMessage userMessage) {
        QueueMessage queueMessage = convertUserMessageToQueueMessage(userMessage);
        messageProducer.sendMessage(queueMessage);
        return queueMessage;
    }
}
