package com.miu.registration.Service;

import com.miu.registration.dto.CourseDTO;
import com.miu.registration.model.Course;

import java.util.List;

public interface CourseServiceInterface {

    public List<Course> getAllCourses();
    public void addNewCourse(CourseDTO courseDTO);
}
