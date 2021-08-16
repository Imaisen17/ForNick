package com.swifty.service.education.education.service.controllers;

import com.swifty.service.education.education.service.entity.Course;
import com.swifty.service.education.education.service.entity.User;
import com.swifty.service.education.education.service.services.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
@Slf4j
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable("id") Long courseId){
        log.info("inside getCourseById method of CourseController");
        return courseService.findCourseById(courseId);
    }

    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course){
        log.info("inside addCourse method of CourseController");
        return courseService.saveCourse(course);
    }
}
