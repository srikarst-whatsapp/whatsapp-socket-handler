package com.whatsapp.whatsappsockethandler.service;

import com.whatsapp.whatsappsockethandler.dto.BaseMessage;
import com.whatsapp.whatsappsockethandler.dto.QueueMessage;
import com.whatsapp.whatsappsockethandler.dto.UserMessage;

public interface MessageService {
    QueueMessage convertUserMessageToQueueMessage(BaseMessage userMessage);

    QueueMessage handleMessage(UserMessage userMessage);

    String token();
}
