package com.whatsapp.whatsappsockethandler.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class QueueMessage extends BaseMessage {

    public QueueMessage(BaseMessage baseMessage) {
        super(baseMessage);
    }

    @NotBlank(message = "Sender cannot be blank")
    @NonNull
    private String sender;
}
