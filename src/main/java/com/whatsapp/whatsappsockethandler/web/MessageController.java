package com.whatsapp.whatsappsockethandler.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/message")
public class MessageController {

    private final NotificationMessagingTemplate notificationMessagingTemplate;

    @PostMapping("/sender/{senderId}/receiver/{receiverId}")
    public ResponseEntity<String> sendMessage() {
        Message<String> message = new GenericMessage<>("message");
        notificationMessagingTemplate.send("message-received-dev.fifo", message);
        return new ResponseEntity<>("CREATED", HttpStatus.CREATED);
    }
}
