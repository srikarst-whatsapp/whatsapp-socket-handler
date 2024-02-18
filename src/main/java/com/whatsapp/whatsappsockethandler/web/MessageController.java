package com.whatsapp.whatsappsockethandler.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whatsapp.whatsappsockethandler.dto.QueueMessage;
import com.whatsapp.whatsappsockethandler.dto.UserMessage;
import com.whatsapp.whatsappsockethandler.service.MessageService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/message")
public class MessageController {
    private final MessageService messageService;

    @PostMapping("/chat/{chatId}")
    public ResponseEntity<QueueMessage> sendMessage(@PathVariable String chatId, @RequestBody UserMessage userMessage) {
        userMessage.setChatId(chatId);
        QueueMessage queueMessage = messageService.handleMessage(userMessage);
        return new ResponseEntity<>(queueMessage, HttpStatus.CREATED);
    }
}
