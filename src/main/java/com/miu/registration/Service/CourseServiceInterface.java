package com.miu.registration.Service;

import com.miu.registration.dto.CourseDTO;
import com.miu.registration.model.Course;

import java.util.List;

public interface CourseServiceInterface {


    public void addNewCourse(CourseDTO courseDTO);

    void deleteCourseById(Long departmentId);

    void getUpdateCourse(Long id);
    List<Course> fetchCourseList();


}
