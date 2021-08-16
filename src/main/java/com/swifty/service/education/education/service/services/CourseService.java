package com.swifty.service.education.education.service.services;

import com.swifty.service.education.education.service.entity.Course;
import com.swifty.service.education.education.service.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService{
    @Autowired
    CourseRepository courseRepository;

    public Course findCourseById(Long courseId) {
        return courseRepository.findByCourseId(courseId);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteByCourseId(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
