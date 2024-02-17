package com.whatsapp.whatsappsockethandler.service;

import com.whatsapp.whatsappsockethandler.dto.BaseMessage;
import com.whatsapp.whatsappsockethandler.dto.QueueMessage;
import com.whatsapp.whatsappsockethandler.dto.UserMessage;
import com.whatsapp.whatsappsockethandler.producer.MessageProducer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {
    private final MessageProducer messageProducer;

    public String token() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "s";
    }

    @Override
    public QueueMessage convertUserMessageToQueueMessage(BaseMessage baseMessage) {
        token();
        QueueMessage queueMessage = new QueueMessage(baseMessage);
        queueMessage.setSender(1L);
        return queueMessage;
    }

    @Override
    public QueueMessage handleMessage(UserMessage userMessage) {
        QueueMessage queueMessage = convertUserMessageToQueueMessage(userMessage);
        messageProducer.sendMessage(queueMessage);
        return queueMessage;
    }
}
