package com.user.service.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.entity.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        // generate random user id
        UUID uuid=UUID.randomUUID();
        user.setUserId(uuid.toString());
        return userRepo.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(String id) {
        return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found by id : "+id));
    }   
}
