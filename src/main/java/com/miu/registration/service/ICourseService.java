package com.miu.registration.service;

import com.miu.registration.domain.Course;
import com.miu.registration.service.DTO.CourseDTO;

import java.util.List;

public interface CourseServiceInterface {
    public Course addCourseOffering(CourseDTO courseDTO) ;

    public List<CourseDTO> getAllCourse() ;

    public CourseDTO findById(Long id) ;

    public CourseDTO add(CourseDTO courseDTO) ;

    public void deleteById(Long id) ;

    public void update(CourseDTO courseDTO, Long id) ;
}
