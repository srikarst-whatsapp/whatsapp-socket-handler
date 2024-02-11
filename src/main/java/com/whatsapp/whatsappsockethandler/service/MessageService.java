package com.whatsapp.whatsappsockethandler.service;

import java.util.List;

import com.whatsapp.whatsappsockethandler.entity.Message;

public interface MessageService {
    List<Message> getMessages(Long senderId, Long receiverId);

    Message addMessageToChat(Message message, Long senderId, Long receiverId);
}
