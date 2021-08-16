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

    @PutMapping("/edit/{id}")
    public Course editCourse(@PathVariable("id") Long courseId, @RequestBody Course tempCourse){
        log.info("inside editCourse method of CourseController");
        Course course = courseService.findCourseById(courseId);
        course.setCourseName(tempCourse.getCourseName());
        course.setCourseDescription(tempCourse.getCourseDescription());
        course.setCoursePrice(tempCourse.getCoursePrice());
        course.setUserList(tempCourse.getUserList());
        return courseService.saveCourse(course);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable("id") Long courseId){
        log.info("inside deleteCourse method of CourseController");
        courseService.deleteByCourseId(courseId);
    }
}
