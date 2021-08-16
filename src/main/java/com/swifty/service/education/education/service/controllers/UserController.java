package com.swifty.service.education.education.service.controllers;

import com.swifty.service.education.education.service.dto.UserCourseDTO;
import com.swifty.service.education.education.service.entity.Course;
import com.swifty.service.education.education.service.entity.User;
import com.swifty.service.education.education.service.services.CourseService;
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
    @Autowired
    CourseService courseService;

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

    @PostMapping("/link")
    public User addCourseToUser(@RequestBody UserCourseDTO userCourseDTO){
        log.info("inside addCourseToUser method of UserController");
        User user = userService.findUserById(userCourseDTO.getUserId());
        if (user != null){
            Course course = courseService.findCourseById(userCourseDTO.getCourseId());
            if (course != null){
                user.getCourseList().add(course);
            }else{
                log.info("Non-existent course");
                return null;
            }
        }else{
            log.info("Non-existent user");
            return null;
        }
        return userService.saveUser(user);
    }
}
