package com.example.easyproject.service;

import com.example.easyproject.entity.User;
import com.example.easyproject.exception.UserAlreadyExistException;
import com.example.easyproject.exception.UserNotFoundException;
import com.example.easyproject.model.UserModel;
import com.example.easyproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registration(User user) throws UserAlreadyExistException {
        if (userRepository.findByUsername(user.getUsername()) != null)
            throw new UserAlreadyExistException("User with that username already exists");
        return userRepository.save(user);
    }

    public UserModel getUser(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User was not found"));
        return UserModel.toModel(user);
    }

    public Long deleteUser(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
