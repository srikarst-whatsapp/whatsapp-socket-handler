package com.whatsapp.whatsappsockethandler.service;

import java.util.List;
import java.util.Optional;

import com.whatsapp.whatsappsockethandler.entity.Chat;
import com.whatsapp.whatsappsockethandler.entity.Message;
import com.whatsapp.whatsappsockethandler.entity.User;
import com.whatsapp.whatsappsockethandler.repository.ChatRepository;
import com.whatsapp.whatsappsockethandler.repository.MessageRepository;
import com.whatsapp.whatsappsockethandler.repository.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

    MessageRepository messageRepository;
    UserRepository userRepository;
    ChatRepository chatRepository;

    ChatService chatService;

    @Override
    public List<Message> getMessages(Long senderId, Long receiverId) {
        Chat chat = chatService.getUnwrappedChat(senderId, receiverId);
        return chat.getMessages();
    }

    @Override
    public Message addMessageToChat(Message message, Long senderId, Long receiverId) {
        @SuppressWarnings("null")
        Optional<User> sender = userRepository.findById(senderId);
        User unwrappedSender = UserServiceImpl.unwrapUser(sender, senderId);
        @SuppressWarnings("null")
        Optional<User> receiver = userRepository.findById(receiverId);
        User unwrappedReceiver = UserServiceImpl.unwrapUser(receiver, receiverId);
        Optional<Chat> chat = chatService.getChat(senderId, receiverId);
        message.setSender(unwrappedSender);
        message.setReceiver(unwrappedReceiver);
        chatService.addMessageToChat(chat, unwrappedSender, unwrappedReceiver, message);
        return message;
    }
}
