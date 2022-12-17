package com.miu.registration.controller;

import com.miu.registration.Service.CourseOfferingService;
import com.miu.registration.Service.Implementation.CourseService;
import com.miu.registration.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseOfferingService courseOfferingService;

    @PostMapping()
    public void addCourse(@RequestBody CourseDTO courseDTO){
        courseService.addNewCourse(courseDTO);
    }
}
