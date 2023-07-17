package com.user.service.services;

import java.util.List;

import com.user.service.entity.User;

public interface UserService {

    User saveUser(User user);

    List<User> getUsers();

    User getUser(String id);
    
    
}
