package com.swifty.service.education.education.service.services;

import com.swifty.service.education.education.service.entity.User;
import com.swifty.service.education.education.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findUserById(Long userId) {
        return userRepository.findByUserId(userId);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
