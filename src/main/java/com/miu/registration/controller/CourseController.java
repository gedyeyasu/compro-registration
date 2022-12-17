package com.miu.registration.controller;

import com.miu.registration.Service.CourseService;
import com.miu.registration.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/registration-events")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(value ="/latest")
    public List<Course> displayCourses(){
        return courseService.getAllCourses();
    }
}
