package com.math.backend.service;

import com.math.backend.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}