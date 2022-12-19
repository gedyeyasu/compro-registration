package com.miu.registration.service.Adaptors;

import com.miu.registration.service.DTO.CourseDTO;
import com.miu.registration.domain.Course;

public class CourseAdapter {


    public  static Course  fromCourseDTO(CourseDTO courseDTO){

        Course course=new Course();
        course.setCode(courseDTO.getCode());
        course.setDescription(courseDTO.getDescription());
        course.setName(courseDTO.getName());
       // course.se
        return course;
    }


    public static CourseDTO  fromCourse(Course course){

        CourseDTO courseDTO=new CourseDTO();
        courseDTO.setCode(course.getCode());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setName(course.getName());
        // course.se
        return courseDTO;
    }

}
