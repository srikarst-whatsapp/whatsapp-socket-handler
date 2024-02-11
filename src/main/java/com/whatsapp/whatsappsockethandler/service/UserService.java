package com.whatsapp.whatsappsockethandler.service;

import com.whatsapp.whatsappsockethandler.entity.User;

public interface UserService {
    User getUser(Long id);

    User getUser(String username);

    User saveUser(User user);
}