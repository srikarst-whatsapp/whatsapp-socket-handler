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

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/message")
public class MessageController {

    @PostMapping("/sender/{senderId}/receiver/{receiverId}")
    public ResponseEntity<String> sendMessage() {
        return new ResponseEntity<>("CREATED", HttpStatus.CREATED);
    }
}
