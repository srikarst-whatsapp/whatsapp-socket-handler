package com.whatsapp.whatsappsockethandler.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class QueueMessage extends BaseMessage {

    public QueueMessage(BaseMessage baseMessage) {
        super(baseMessage);
    }

    @NonNull
    private Long sender;

    private final String status = "SENT";
}
