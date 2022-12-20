package com.miu.registration.service.Impl;

import com.miu.registration.service.Adapters.CourseOfferingAdapter;
import com.miu.registration.service.DTO.CourseDTO;
import com.miu.registration.domain.Course;
import com.miu.registration.repositories.CourseRepository;
import com.miu.registration.service.Adapters.CourseAdapter;
import com.miu.registration.service.DTO.StudentDTO;
import com.miu.registration.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService implements ICourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseAdapter courseAdapter;

    public Course addCourseOffering(CourseDTO courseDTO) {

        var a = courseRepository.save(courseAdapter.getDomainFromDTO(courseDTO));
        return a;
    }

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(courseAdapter::getDTOFromDomain).collect(Collectors.toList());
    }

    public CourseDTO getCourse(String code) {
        Course course = courseRepository.findCourseByCode(code);
        if (course == null)
            return null;
        return courseAdapter.getDTOFromDomain(course);
    }

    public CourseDTO addCourse(CourseDTO courseDTO) {
        Course course = courseAdapter.getDomainFromDTO(courseDTO);
        return courseAdapter.getDTOFromDomain(courseRepository.save(course));
    }


    public Long deleteCourse(String code) {
        Long numOfCoursesDeleted = courseRepository.deleteCourseByCode(code);
        return numOfCoursesDeleted;
    }

    public CourseDTO updateCourse(String code, CourseDTO courseDTO) {
        CourseDTO oldCourse = getCourse(code);
        if (oldCourse==null)
            return  null;
        courseRepository.deleteCourseByCode(code);

        courseRepository.save(courseAdapter.getDomainFromDTO(courseDTO));

        return courseDTO;

    }
}