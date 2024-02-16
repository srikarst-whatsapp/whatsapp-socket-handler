package com.whatsapp.whatsappsockethandler.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class BaseMessage {

    @Id
    @NonNull
    private Long id;

    @NonNull
    private Long chatId;

    @NotBlank(message = "Body cannot be blank")
    @NonNull
    private String body;
}
