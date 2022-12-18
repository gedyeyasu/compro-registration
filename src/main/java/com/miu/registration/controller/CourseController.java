package com.miu.registration.controller;

import com.miu.registration.Service.Implementation.CourseOfferingService;
import com.miu.registration.Service.Implementation.CourseService;
import com.miu.registration.dto.CourseDTO;
import com.miu.registration.dto.CourseOfferingDTO;
import com.miu.registration.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseOfferingService courseOfferingService;

    // creates new course
    @PostMapping("/courses")
    public void addCourse(@RequestBody CourseDTO courseDTO){
        courseService.addNewCourse(courseDTO);
    }
    @GetMapping("/courses")

    public List<Course> fetchCourseList()
    {
        return courseService.fetchCourseList();
    }

    // delete course

    @DeleteMapping("/courses/{id}")

    public String deleteCourseById(@PathVariable("id") Long departmentId)
    {
        courseService.deleteCourseById(departmentId);
        return "Deleted Successfully";
    }
    // edit a course
    @PutMapping(value="/courses/{id}")
    public  void getUpdateCourse(@PathVariable Long id) {

        courseService.getUpdateCourse(id);


    }
    @PostMapping("/offerings")

    public void addNewCourseOffering(@RequestBody CourseOfferingDTO courseOfferingDTO){
        courseOfferingService.addNewCourseOffering(courseOfferingDTO);
    }
}
