package com.miu.registration.service.Adapters;

import com.miu.registration.service.DTO.CourseDTO;
import com.miu.registration.domain.Course;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseAdapter implements IAdapter<Course, CourseDTO>{

    @Override
    public Course getDomainFromDTO(CourseDTO courseDTO) {
        Course course = new Course();

        course.setCode(courseDTO.getCode());
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());

        return course;
    }

    @Override
    public CourseDTO getDTOFromDomain(Course course) {
        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setCode(course.getCode());
        courseDTO.setName(course.getName());
        courseDTO.setDescription(course.getDescription());

        return courseDTO;
    }

    @Override
    public List<Course> getDomainsFromDTOs(List<CourseDTO> courseDTOS) {
        return courseDTOS.stream()
                .map(courseDTO -> getDomainFromDTO(courseDTO))
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getDTOsFromDomains(List<Course> courses) {
        return courses.stream()
                .map(course -> getDTOFromDomain(course))
                .collect(Collectors.toList());
    }
}
