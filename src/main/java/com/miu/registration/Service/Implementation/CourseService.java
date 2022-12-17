package com.miu.registration.Service.Implementation;

import com.miu.registration.Repository.CourseRepository;
import com.miu.registration.Service.CourseServiceInterface;
import com.miu.registration.dto.CourseDTO;
import com.miu.registration.model.Course;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService  implements CourseServiceInterface {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return null;
    }

    @Override
    public void addNewCourse(CourseDTO courseDTO) {
        Course course=new Course();
        BeanUtils.copyProperties(courseDTO,course);
         courseRepository.save(course);
    }
}
