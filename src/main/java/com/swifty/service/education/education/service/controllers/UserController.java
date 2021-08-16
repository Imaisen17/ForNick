package com.swifty.service.education.education.service.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.swifty.service.education.education.service.entity.User;
import com.swifty.service.education.education.service.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long userId){
        log.info("inside getUserById method of UserController");
        return userService.findUserById(userId);
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        log.info("inside addUser method of UserController");
        return userService.saveUser(user);
    }

    @PutMapping("/edit/{id}")
    public User editUser(@PathVariable("id") Long userId, @RequestBody User tempUser){
        log.info("inside editUser method of UserController");
        User user = userService.findUserById(userId);
        user.setUsername(tempUser.getUsername());
        user.setEmail(tempUser.getEmail());
        user.setPassword(tempUser.getPassword());
        user.setCourseList(tempUser.getCourseList());
        return userService.saveUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long userId){
        log.info("inside deleteUser method of UserController");
        userService.deleteByUserId(userId);
    }
}
