package com.whatsapp.whatsappsockethandler.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(ChatId.class)
@Table(name = "chat")
public class Chat {

    // @NotBlank(message = "Sender cannot be blank")
    @Id
    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private User sender;

    // @NotBlank(message = "Receiver cannot be blank")
    @Id
    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "receiver_id", referencedColumnName = "id")
    private User receiver;

    @NonNull
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @OrderBy("id DESC") // Assuming 'date' is the field in the Message entity
    private List<Message> messages;

    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "latest_message_id", referencedColumnName = "id")
    private Message latestMessage;
}
