package com.miu.registration.service.Impl;

import com.miu.registration.service.DTO.CourseDTO;
import com.miu.registration.domain.Course;
import com.miu.registration.repositories.CourseRepo;
import com.miu.registration.service.Adapters.CourseAdapter;
import com.miu.registration.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService implements ICourseService {

    @Autowired
    CourseRepo courseRepo;

    public Course addCourseOffering(CourseDTO courseDTO) {

        var a = courseRepo.save(CourseAdapter.fromCourseDTO(courseDTO));


        return a;
    }

    public List<CourseDTO> getAllCourse() {

        return courseRepo.findAll().stream()
                .map(CourseAdapter::fromCourse).collect(Collectors.toList());
    }

    public CourseDTO findById(Long id) {
        var a = courseRepo.findById(id);
        if (a.isPresent())
            return CourseAdapter.fromCourse(a.get());
        else
            return null;
    }

    public CourseDTO add(CourseDTO courseDTO) {
        Course course = CourseAdapter.fromCourseDTO(courseDTO);
        return CourseAdapter.fromCourse(courseRepo.save(course));
    }


    public void deleteById(Long id) {
        courseRepo.deleteById(id);
    }

    public void update(CourseDTO courseDTO, Long id) {
        var course = courseRepo.findById(id);
        if (course.isPresent() && courseDTO != null) {
            Course course1 = course.get();
            Course course2 = CourseAdapter.fromCourseDTO(courseDTO);

            course1.setName(course2.getName());
            course1.setCode(course2.getCode());
            course1.setDescription(course2.getDescription());

            courseRepo.save(course1);

        }
    }
}