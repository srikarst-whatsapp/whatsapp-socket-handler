package com.whatsapp.whatsappsockethandler.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class BaseMessage {

    BaseMessage(BaseMessage baseMessage) {
        this.id = baseMessage.getId();
        this.chatId = baseMessage.chatId;
        this.body = baseMessage.body;
    }

    @NonNull
    private String id;

    @NonNull
    private String chatId;

    @NotBlank(message = "Body cannot be blank")
    @NonNull
    private String body;
}
