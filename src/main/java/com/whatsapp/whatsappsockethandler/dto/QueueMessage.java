package com.whatsapp.whatsappsockethandler.dto;

import jakarta.persistence.Entity;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class QueueMessage extends BaseMessage {
    @NonNull
    private Long sender;

    @NonNull
    private final String status = "SENT";
}
