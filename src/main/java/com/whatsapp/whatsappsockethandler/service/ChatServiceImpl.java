package com.whatsapp.whatsappsockethandler.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.whatsapp.whatsappsockethandler.entity.Chat;
import com.whatsapp.whatsappsockethandler.entity.Message;
import com.whatsapp.whatsappsockethandler.entity.User;
import com.whatsapp.whatsappsockethandler.exception.ChatNotFoundException;
import com.whatsapp.whatsappsockethandler.repository.ChatRepository;
import com.whatsapp.whatsappsockethandler.repository.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ChatServiceImpl implements ChatService {

    ChatRepository chatRepository;
    UserRepository userRepository;

    @Override
    public Optional<Chat> getChat(Long senderId, Long receiverId) {
        Optional<Chat> chat = chatRepository.findBySenderIdAndReceiverIdOrReceiverIdAndSenderId(senderId, receiverId,
                senderId,
                receiverId);
        return chat;
    }

    @Override
    public List<Message> getMessagesInChat(Long senderId, Long receiverId) {
        Optional<Chat> chat = getChat(senderId, receiverId);
        Chat unwrappedChat = unwrapChat(chat);
        return unwrappedChat.getMessages();
    }

    @Override
    public Chat getUnwrappedChat(Long senderId, Long receiverId) {
        Optional<Chat> chat = getChat(senderId, receiverId);
        return unwrapChat(chat);
    }

    @Override
    public Chat addMessageToChat(Optional<Chat> chat, User sender, User receiver, Message message) {
        Chat unwrappedChat;
        if (!chat.isPresent())
            unwrappedChat = new Chat(sender, receiver, new ArrayList<Message>(), message);
        else {
            unwrappedChat = chat.get();
            unwrappedChat.setSender(sender);
            unwrappedChat.setReceiver(receiver);
            unwrappedChat.setLatestMessage(message);
        }
        unwrappedChat.getMessages().add(message);
        return chatRepository.save(unwrappedChat);
    }

    static Chat unwrapChat(Optional<Chat> entity) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new ChatNotFoundException();
    }
}
