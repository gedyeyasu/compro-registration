package com.miu.registration.service;

import com.miu.registration.domain.Course;
import com.miu.registration.service.DTO.CourseDTO;

import java.util.List;

public interface ICourseService {
    public Course addCourseOffering(CourseDTO courseDTO) ;

    public List<CourseDTO> getAllCourses() ;

    public CourseDTO getCourse(String code) ;

    public CourseDTO addCourse(CourseDTO courseDTO) ;

    public Long deleteCourse(String code) ;

    public CourseDTO updateCourse(String code, CourseDTO courseDTO);
}
