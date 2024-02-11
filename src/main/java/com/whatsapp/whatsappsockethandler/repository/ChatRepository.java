package com.whatsapp.whatsappsockethandler.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.whatsapp.whatsappsockethandler.entity.Chat;
import com.whatsapp.whatsappsockethandler.entity.ChatId;

public interface ChatRepository extends CrudRepository<Chat, ChatId> {
    Optional<Chat> findBySenderIdAndReceiverIdOrReceiverIdAndSenderId(Long senderId, Long receiverId, Long receiverId2,
            Long senderId2);
}