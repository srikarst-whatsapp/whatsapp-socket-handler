package com.whatsapp.whatsappsockethandler.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whatsapp.whatsappsockethandler.producer.MessageProducer;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/message")
public class MessageController {
    private MessageProducer messageProducer;

    @PostMapping("/sender/{senderId}/receiver/{receiverId}")
    public ResponseEntity<String> sendMessage(@RequestBody String str) {
        messageProducer.sendMessage(str);
        return new ResponseEntity<>(str, HttpStatus.CREATED);
    }
}
