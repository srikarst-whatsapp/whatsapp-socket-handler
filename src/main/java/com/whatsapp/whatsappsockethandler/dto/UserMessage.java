package com.whatsapp.whatsappsockethandler.dto;

import java.util.UUID;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class UserMessage extends BaseMessage {

    private final String id = UUID.randomUUID().toString();;

}
