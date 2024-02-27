package com.whatsapp.whatsappsockethandler.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.Past;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class UserMessage extends BaseMessage {

    @NonNull
    private final String id = UUID.randomUUID().toString();

    @NonNull
    private final String status = "SENT";

    @Past(message = "The created time must be in the past")
    @NonNull
    private final LocalDateTime createdTimestamp = LocalDateTime.now();

}
