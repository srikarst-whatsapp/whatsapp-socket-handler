package com.whatsapp.whatsappsockethandler.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Past;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class QueueMessage extends BaseMessage {

    public QueueMessage(BaseMessage baseMessage) {
        super(baseMessage);
    }

    @NonNull
    private String sender;

    private final String status = "SENT";

    @Past(message = "The created time must be in the past")
    @NonNull
    private final LocalDateTime createdTimestamp = LocalDateTime.now();
}
