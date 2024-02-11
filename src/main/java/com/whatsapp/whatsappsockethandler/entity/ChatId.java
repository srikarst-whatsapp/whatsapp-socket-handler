package com.whatsapp.whatsappsockethandler.entity;

import java.io.Serializable;
import java.util.Objects;

public class ChatId implements Serializable {

    private User sender;
    private User receiver;

    // constructors, getters, setters, and equals/hashCode methods...

    // Make sure to implement equals and hashCode based on the contents of the key
    // class.
    // This is important for correct behavior in collections and comparisons.
}
