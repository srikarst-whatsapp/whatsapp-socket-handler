package com.whatsapp.whatsappsockethandler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.whatsapp.whatsappsockethandler.entity.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findBySenderIdAndReceiverId(Long senderId, Long receiverId);
}