package com.whatsapp.whatsappsockethandler.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<String> sendMessage(@RequestBody String str) {
        Message<String> message = new GenericMessage<>("message");
        Map<String, Object> headers = new HashMap<>();
        headers.put("message-group-id", "messageGroupId");
        headers.put("message-deduplication-id", str);
        notificationMessagingTemplate.convertAndSend("message-received-dev.fifo", message, headers);
        return new ResponseEntity<>(str, HttpStatus.CREATED);
    }
}
