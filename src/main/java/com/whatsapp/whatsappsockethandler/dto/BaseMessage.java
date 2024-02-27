package com.whatsapp.whatsappsockethandler.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
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
        this.status = baseMessage.getStatus();
        this.createdTimestamp = baseMessage.getCreatedTimestamp();
    }

    @NotBlank(message = "Id cannot be blank")
    @NonNull
    private String id;

    @NotBlank(message = "ChatId cannot be blank")
    @NonNull
    private String chatId;

    @NotBlank(message = "Body cannot be blank")
    @NonNull
    private String body;

    @NonNull
    private String status;

    @Past(message = "The created time must be in the past")
    @NonNull
    private LocalDateTime createdTimestamp;
}
